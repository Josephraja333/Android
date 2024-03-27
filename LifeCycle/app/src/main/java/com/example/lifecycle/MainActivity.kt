package com.example.lifecycle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        println("This is onCreate")
    }

    override fun onStart() {
        super.onStart()
        println("This is onStart")
    }

    override fun onResume() {
        super.onResume()
        println("This is onResume")
    }

    override fun onPause() {
        super.onPause()
        println("This is onPause")
    }

    override fun onStop() {
        super.onStop()
        println("This is onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        println("This is onDestroy")
    }

    override fun onRestart() {
        super.onRestart()
        println("This is onRestart")
    }
}