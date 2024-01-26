package com.techmania.mathga

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    lateinit var add:Button
    lateinit var sub:Button
    lateinit var mul:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        add=findViewById(R.id.buttonadd)
        sub=findViewById(R.id.buttonsub)
        mul=findViewById(R.id.buttonmul)
        add.setOnClickListener {
            val intent = Intent(this@MainActivity,gameactivity::class.java)
            startActivity(intent)
        }
        sub.setOnClickListener {
            val intent=Intent(this@MainActivity,gameactivity2::class.java)
            startActivity(intent)
        }
        mul.setOnClickListener {
            val intent=Intent(this@MainActivity,gameactivity3::class.java)
            startActivity(intent)
        }
    }
}