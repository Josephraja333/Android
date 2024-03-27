package com.example.newcalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()
        val eql = findViewById<Button>(R.id.eqs)
        val ac = findViewById<Button>(R.id.ac)
        val bk = findViewById<Button>(R.id.bk)
        val tv1 = findViewById<TextView>(R.id.tv1)
        var tv = findViewById<TextView>(R.id.tv)
        var disp = ""

        val buttonIds = listOf(R.id.one, R.id.two, R.id.thr, R.id.fur, R.id.fiv, R.id.six, R.id.sev, R.id.eit, R.id.nin,R.id.zro,R.id.dot,R.id.pls, R.id.min, R.id.mul, R.id.div)
        val buttons = buttonIds.map{findViewById<Button>(it) }

        for(items in buttons){
            items.setOnClickListener {
                disp += items.text
                tv.text = disp
            }
        }

        ac.setOnClickListener {
            if(tv.text.toString().length==0){
                tv1.text = ""
            }
            tv.text = ""
            disp = ""
        }

        bk.setOnClickListener {
            tv.text = tv.text.toString().slice(0..(tv.text.toString().length-2))
            disp = tv.text.toString()
        }

        eql.setOnClickListener {
            var str1 = ""
            var temp = disp
            var str2 = ""
            var sym = ""
            var yes = false
            var oper = false
            if(temp.contains('.') || temp.contains('/')) yes = true
            if(temp.contains('+') || temp.contains('-') || temp.contains('/') || temp.contains('×')) oper = true

            for(i in temp.indices){
                if(temp[i] !='+' && temp[i] !='-' && temp[i] !='/' && temp[i] !='×'){
                    str1+=temp[i]
                }
                else if(str1=="") continue
                else{
                    sym = temp[i].toString()
                    temp = temp.slice(i+1..temp.length-1)
                    break
                }
            }

            for (i in temp.indices) {
                if (temp[i] != '+' && temp[i] != '-' && temp[i] != '/' && temp[i] != '×') {
                    str2 += temp[i]
                }
                if ((temp[i] == '+' || temp[i] == '-' || temp[i] == '/' || temp[i] == '×' || i == temp.length - 1) && (str2!="" && str1!="")) {

                    when (sym) {
                        "+" -> {
                            str1 = (str1.toFloat() + str2.toFloat()).toString()
                        }
                        "-" -> {
                            str1 = (str1.toFloat() - str2.toFloat()).toString()
                        }
                        "/" -> {
                            str1 = (str1.toFloat() / str2.toFloat()).toString()
                        }
                        "×" -> {
                            str1 = (str1.toFloat() * str2.toFloat()).toString()
                        }
                    }
                    sym = temp[i].toString()
                    str2 = ""
                }
            }

            if(oper) tv1.text = str1
            if(!(yes) && oper){
                tv1.text = tv1.text.toString().slice(0..tv1.text.toString().length-3)
            }
        }


    }
}