package com.example.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_finish.*
import kotlinx.android.synthetic.main.activity_finish.view.*

class FinishActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_finish)
        val userName = intent.getStringExtra(Constants.USER_NAME).toString()
        val totalQuestions = intent.getIntExtra(Constants.TOTAL_QUESTIONS,0)
        val correctAnswer = intent.getIntExtra(Constants.CORRECT_ANSWER,0)
        btn_cancel.setOnClickListener {
            startActivity(Intent(this,MainActivity::class.java))
        }
        Name.text = userName
        score.text = "$correctAnswer/$totalQuestions Score"
        txt_score.text = "You attempt $totalQuestions questions and from that $correctAnswer answer is correct."

    }
    override fun onBackPressed(){
        this.moveTaskToBack(false)
    }
}