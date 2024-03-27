package com.example.dictionary

import android.Manifest
import android.annotation.SuppressLint
import android.content.Intent
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.speech.RecognizerIntent
import android.speech.tts.TextToSpeech
import android.text.Editable
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.lifecycle.lifecycleScope
import com.example.dictionary.API.DictionaryInstance
import com.example.dictionary.databinding.ActivityMainBinding
import kotlinx.coroutines.launch
import java.util.Locale

class MainActivity : AppCompatActivity(), TextToSpeech.OnInitListener {

    private lateinit var binding: ActivityMainBinding
    private lateinit var speechInputLauncher: ActivityResultLauncher<Intent>
    private lateinit var textToSpeech: TextToSpeech
    private var a = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        textToSpeech = TextToSpeech(this, this)


        if (!isMicrophonePermissionGranted()) {
            requestMicrophonePermission()
        }

        speechInputLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == RESULT_OK) {
                val spokenText = result.data?.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS)?.getOrNull(0) ?: "No speech input"
                binding.tv.text = Editable.Factory.getInstance().newEditable(spokenText)
            }
        }

        binding.enter.setOnClickListener {
            meaning()
        }

        binding.mic.setOnClickListener {
            if(a) startVoiceInput()
            else requestMicrophonePermission()
        }

        binding.sound.setOnClickListener {
            speakText(binding.tv.text.toString())
        }
    }

    private fun speakText(text: String) {
        textToSpeech.speak(text, TextToSpeech.QUEUE_FLUSH, null, null)
    }

    override fun onInit(status: Int) {
        if (status == TextToSpeech.SUCCESS) {
            val result = textToSpeech.setLanguage(Locale.US)

            if (result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                Toast.makeText(this, "Language not supported or missing data", Toast.LENGTH_SHORT)
                    .show()
            }
        } else {
            Toast.makeText(this, "TextToSpeech initialization failed", Toast.LENGTH_SHORT).show()
        }
    }

    @SuppressLint("SetTextI18n")
    private fun meaning() {
        lifecycleScope.launch {
            try {
                val response = DictionaryInstance.api.getMeaning(binding.tv.text.toString())
                if (response.isSuccessful) {
                    val meaning = response.body()?.first()?.meanings
                    var ph = "Phonetics:\n"
                    ph += response.body()?.first()?.phonetic ?: "None"
                    var ps = "Part Of Speech:\n"
                    var ant = "Antonyms:\n"
                    var syn = "Synonyms:\n"
                    var def = "Definitions:\n"

                    meaning?.forEach {
                        ps += it.partOfSpeech + " "
                        it.antonyms.forEach {
                            ant += it + "\n"
                        }

                        it.synonyms.forEach {
                            syn += it + "\n"
                        }
                        it.definitions.forEach {
                            def += it.definition + "\n\n"
                        }
                    }

                    val text = "$ph \n\n $ps \n\n $ant \n\n $syn \n\n $def"

                    binding.text2.text = text
                } else {
                    binding.text2.text = "Invalid word"
                    println("MainActivity Unsuccessful response")
                }
            } catch (e: Exception) {
                binding.text2.text = "Something went wrong on our side"
                println("MainActivity Network request failed")
            }
        }
    }

    private fun isMicrophonePermissionGranted(): Boolean {
        return ContextCompat.checkSelfPermission(
            this,
            Manifest.permission.RECORD_AUDIO
        ) == PackageManager.PERMISSION_GRANTED
    }

    private fun requestMicrophonePermission() {
        ActivityCompat.requestPermissions(
            this,
            arrayOf(Manifest.permission.RECORD_AUDIO),
            1
        )
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        if (requestCode == 1) {
            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                a = true
            } else {
                Toast.makeText(
                    this,
                    "Microphone permission is required for voice input",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }

    private fun startVoiceInput() {
        val intent = Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH)
        intent.putExtra(
            RecognizerIntent.EXTRA_LANGUAGE_MODEL,
            RecognizerIntent.LANGUAGE_MODEL_FREE_FORM
        )
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault())
        intent.putExtra(RecognizerIntent.EXTRA_PROMPT, "Speak something")

        speechInputLauncher.launch(intent)
    }

    override fun onDestroy() {
        if (::textToSpeech.isInitialized) {
            textToSpeech.stop()
            textToSpeech.shutdown()
        }
        super.onDestroy()
    }
}
