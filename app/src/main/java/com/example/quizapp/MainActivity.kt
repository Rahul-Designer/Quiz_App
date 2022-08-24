package com.example.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_start.setOnClickListener {
            if (edt_name.text.toString().isEmpty()){
                edt_name.setError("Please enter the name")
            }
            else{
                val intent = Intent(this,QuestionActivity::class.java)
                intent.putExtra(Constants.USER_NAME, edt_name.text.toString())
                startActivity(intent)
                finish()
            }
        }
    }

    override fun onBackPressed() {
        this.moveTaskToBack(false)
    }
}