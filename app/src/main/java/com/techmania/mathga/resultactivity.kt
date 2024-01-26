package com.techmania.mathga

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class resultactivity : AppCompatActivity() {
    lateinit var resul:TextView
    lateinit var agai:Button
    lateinit var exi:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultactivity)
        resul=findViewById(R.id.textViewresult)
        agai=findViewById(R.id.buttonagai)
        exi=findViewById(R.id.buttonexi)
        val scor=intent.getIntExtra("score",0)
        resul.text="score="+scor
        agai.setOnClickListener {
            val intent=Intent(this@resultactivity,MainActivity::class.java)
            startActivity(intent)
            finish()
        }
        exi.setOnClickListener{
            val intent=Intent(Intent.ACTION_MAIN)
            intent.addCategory(Intent.CATEGORY_HOME)
            intent.flags=Intent.FLAG_ACTIVITY_NEW_TASK
            startActivity(intent)
        }
    }
}