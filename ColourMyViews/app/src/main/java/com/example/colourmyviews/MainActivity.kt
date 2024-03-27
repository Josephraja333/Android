package com.example.colourmyviews

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttons = listOf(R.id.box_one_text,R.id.button1,R.id.button2,R.id.button3,R.id.textView,R.id.textView2,R.id.textView3,R.id.textView4)
        val button = buttons.map{findViewById<TextView>(it)}

        for(item in button){
            item.setOnClickListener {
                when(item.id){
                    R.id.box_one_text->{
                        item.setBackgroundColor(Color.BLACK);
                    }
                    R.id.button1->{
                        item.setBackgroundColor(Color.GREEN);
                        var a = findViewById<TextView>(R.id.textView2)
                        a.setBackgroundColor(Color.GREEN)
                    }
                    R.id.button2->{
                        item.setBackgroundColor(Color.RED);
                        var a = findViewById<TextView>(R.id.textView3)
                        a.setBackgroundColor(Color.RED)
                    }
                    R.id.button3->{
                        item.setBackgroundColor(Color.YELLOW);
                        var a = findViewById<TextView>(R.id.textView4)
                        a.setBackgroundColor(Color.YELLOW)
                    }
                    R.id.textView->{
                        item.setBackgroundColor(Color.MAGENTA);
                    }
                    R.id.textView2->{
                        item.setBackgroundColor(Color.RED);
                    }
                    R.id.textView3->{
                        item.setBackgroundColor(Color.YELLOW);
                    }
                    R.id.textView4->{
                        item.setBackgroundColor(Color.BLUE);
                    }
                }
            }
            val cl = findViewById<ConstraintLayout>(R.id.cl)
            cl.setOnClickListener{
                cl.setBackgroundColor(Color.GRAY)
            }
        }
    }
}