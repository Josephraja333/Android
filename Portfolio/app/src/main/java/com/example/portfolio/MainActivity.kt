package com.example.portfolio

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val skl = findViewById<Button>(R.id.bt1)
        val edc = findViewById<Button>(R.id.bt2)
        val wrk = findViewById<Button>(R.id.bt3)
        val ach = findViewById<Button>(R.id.bt4)

        skl.setOnClickListener {
            intent = Intent(this, skilll::class.java)
            startActivity(intent)
        }
        edc.setOnClickListener {
            intent = Intent(this, Education::class.java)
            startActivity(intent)
        }
        wrk.setOnClickListener {
            intent = Intent(this, Work::class.java)
            startActivity(intent)
        }
        ach.setOnClickListener {
            intent = Intent(this, Achievements::class.java)
            startActivity(intent)
        }
    }
}