package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val roll = findViewById<Button>(R.id.rl)
        val iv = findViewById<ImageView>(R.id.dice)

        roll.setOnClickListener {
            val rn = Random.nextInt(6)+1
            val img = when(rn){
                1-> R.drawable.dice_1
                2 -> R.drawable.dice_2
                3-> R.drawable.dice_3
                4 -> R.drawable.dice_4
                5-> R.drawable.dice_5
                6 -> R.drawable.dice_6
                else -> {}
            }

            iv.setImageResource(img as Int)
        }
    }
}