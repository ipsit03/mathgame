package com.techmania.mathga

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import java.util.Locale
import kotlin.random.Random

class gameactivity2 : AppCompatActivity() {
    lateinit var textscore:TextView
    lateinit var textlife:TextView
    lateinit var texttime:TextView
    lateinit var textquestion:TextView
    lateinit var edittextanswer:EditText
    lateinit var buttonok:Button
    lateinit var buttonnext:Button
    var correctanswer=0
    var userscore=0
    var userlife=3
    lateinit var timer:CountDownTimer
    private val starttimerinmillis:Long=60000
    var timeleftinmillis:Long=starttimerinmillis
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gameactivity)
        supportActionBar!!.title="sub"
        textscore=findViewById(R.id.textViewscore)
        textlife=findViewById(R.id.textViewlife)
        texttime=findViewById(R.id.textViewtime)
        textquestion=findViewById(R.id.textViewquestion)
        edittextanswer=findViewById(R.id.editTextanswer)
        buttonok=findViewById(R.id.buttonok)
        buttonnext=findViewById(R.id.buttonnext)
        gameContinue()
        buttonok.setOnClickListener {
            val input=edittextanswer.text.toString()
            if(input=="")
            {
                Toast.makeText(applicationContext,"Please write answer or click next button",Toast.LENGTH_LONG).show()
            }
            else
            {
                pauseTimer()
                val useranswer=input.toInt()
                if(useranswer==correctanswer)
                {
                    userscore=userscore+10
                    textquestion.text="congrat answer is correct"
                    textscore.text=userscore.toString()
                }
                else
                {
                    userlife--
                    textquestion.text="so answer is wrong"
                    textlife.text=userlife.toString()
                }

            }
        }
        buttonnext.setOnClickListener {
            pauseTimer()
            resetTimer()
            gameContinue()
            edittextanswer.setText("")
            if(userlife==0)
            {
                val intent=Intent(this@gameactivity2,resultactivity::class.java)
                intent.putExtra("score",userscore)
                startActivity(intent)
                finish()
            }
            else
            {
                gameContinue()
            }
        }
    }
    fun gameContinue(){
        val number1=Random.nextInt(1,12)
        val number2=Random.nextInt(1,12)
        textquestion.text="$number1-$number2"
        correctanswer=number1-number2
        startTimer()
    }
    fun startTimer(){
        timer=object:CountDownTimer(timeleftinmillis,1000){
            override fun onTick(millisuntilfinished: Long) {
                timeleftinmillis=millisuntilfinished
                updateText()
            }

            override fun onFinish() {
                pauseTimer()
                resetTimer()
                updateText()
                userlife--
                textlife.text=userlife.toString()
                textquestion.text="so time is up"
            }

        }.start()
    }
    fun updateText(){
        val remainningtime:Int=(timeleftinmillis/1000).toInt()
        texttime.text=String.format(Locale.getDefault(),"%02d",remainningtime)
    }
    fun pauseTimer(){
        timer.cancel()
    }
    fun resetTimer(){
        timeleftinmillis=starttimerinmillis
        updateText()
    }
}