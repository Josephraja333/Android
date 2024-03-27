package com.example.travelapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    var ci = 1;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val pre = findViewById<ImageButton>(R.id.prev)
        val nxt = findViewById<ImageButton>(R.id.next)
        val tv = findViewById<TextView>(R.id.tv)
        var ar = arrayOf("DBZ","Kaneki","Ken","Pikachu","Train")

        pre.setOnClickListener{
            if(ci>1){
                var imgid = this.resources.getIdentifier("pic$ci","id",packageName)
                var image = findViewById<ImageView>(imgid)
                image.alpha = 0f
                ci--

                imgid = this.resources.getIdentifier("pic$ci","id",packageName)
                image = findViewById<ImageView>(imgid)
                image.alpha = 1f
                tv.text = ar[ci-1]
            }
        }

        nxt.setOnClickListener{
            if(ci<5){
                var imgid = this.resources.getIdentifier("pic$ci","id",packageName)
                var image = findViewById<ImageView>(imgid)
                image.alpha = 0f
                ci++

                imgid = this.resources.getIdentifier("pic$ci","id",packageName)
                image = findViewById<ImageView>(imgid)
                image.alpha = 1f
                tv.text = ar[ci-1]
            }
        }
    }
}