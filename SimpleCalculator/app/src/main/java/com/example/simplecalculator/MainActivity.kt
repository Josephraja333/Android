package com.example.simplecalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.google.android.material.textfield.TextInputLayout
import java.lang.Math.abs

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val add = findViewById<Button>(R.id.btn1)
        val sub = findViewById<Button>(R.id.btn2)
        val mul = findViewById<Button>(R.id.btn3)
        val div = findViewById<Button>(R.id.btn4)
        val t1 = findViewById<TextInputLayout>(R.id.t1)
        val t2 = findViewById<TextInputLayout>(R.id.t2)
        var tv = findViewById<TextView>(R.id.tv)

        add.setOnClickListener {
            val i1 = t1.editText?.text.toString().toInt()
            val i2 = t2.editText?.text.toString().toInt()
            tv.text = (i1+i2).toString()
        }
        sub.setOnClickListener {
            val i1 = t1.editText?.text.toString().toInt()
            val i2 = t2.editText?.text.toString().toInt()
            tv.text = abs((i1-i2)).toString()
        }
        mul.setOnClickListener {
            val i1 = t1.editText?.text.toString().toInt()
            val i2 = t2.editText?.text.toString().toInt()
            tv.text = (i1*i2).toString()
        }
        div.setOnClickListener {
            val i1 = t1.editText?.text.toString().toInt()
            val i2 = t2.editText?.text.toString().toInt()
            tv.text = (i1%i2).toString()
        }
    }
}