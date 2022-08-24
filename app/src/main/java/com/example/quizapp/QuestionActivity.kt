package com.example.quizapp

import android.content.Intent
import android.content.res.ColorStateList
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.Button
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_question.*

class QuestionActivity : AppCompatActivity(), View.OnClickListener {

    private var mCurrentPosition: Int = 1
    private var mQuestionList: ArrayList<Question>? = null
    private var mSelectionOptionPosition: Int = 0
    private var mCorrectAnswer : Int = 0
    private var mUserName: String? =null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question)
        progressBar.setProgressTintList(ColorStateList.valueOf(Color.WHITE));

        mUserName = intent.getStringExtra(Constants.USER_NAME)
        mQuestionList = Constants.getQuestion()
        setQuestion()

        optionA.setOnClickListener(this)
        optionB.setOnClickListener(this)
        optionC.setOnClickListener(this)
        optionD.setOnClickListener(this)
        btn_submit.setOnClickListener(this)

    }

    private fun setQuestion() {

        val question = mQuestionList!![mCurrentPosition - 1]

        defaultOptionsView()

        if(mCurrentPosition == mQuestionList!!.size){
            btn_submit.text = "Submit"
        }
        else{
            btn_submit.text = "Submit"
        }

        progressBar.progress = mCurrentPosition
        progressRate.text = "$mCurrentPosition" + "/" + progressBar.max

        tv_question.text = question!!.question
        iv_image.setImageResource(question.image)
        optionA.text = question.optionOne
        optionB.text = question.optionTwo
        optionC.text = question.optionThree
        optionD.text = question.optionFour
        setAnimation()


    }

    private fun setAnimation() {
        val animationSlideDown = AnimationUtils.loadAnimation(this, R.anim.slide_in)
        tv_question.startAnimation(animationSlideDown)
        iv_image.startAnimation(animationSlideDown)
        optionA.startAnimation(animationSlideDown)
        optionB.startAnimation(animationSlideDown)
        optionC.startAnimation(animationSlideDown)
        optionD.startAnimation(animationSlideDown)
    }

    private fun defaultOptionsView() {
        val options = ArrayList<Button>()
        options.add(0, optionA)
        options.add(1, optionB)
        options.add(2, optionC)
        options.add(3, optionD)

        for (option in options) {
            option.background = ContextCompat.getDrawable(this, R.drawable.option_bg)
            option.setTextColor(Color.parseColor("#8D000000"))
        }
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.optionA -> selectedOptionView(optionA, 1)
            R.id.optionB -> selectedOptionView(optionB, 2)
            R.id.optionC -> selectedOptionView(optionC, 3)
            R.id.optionD -> selectedOptionView(optionD, 4)
            R.id.btn_submit -> {
                if (mSelectionOptionPosition == 0){
                    mCurrentPosition ++

                    when{
                        mCurrentPosition <=mQuestionList!!.size ->{

                            setQuestion()
                        }
                        else ->{
                            val intent = Intent(this,FinishActivity::class.java)
                            intent.putExtra(Constants.USER_NAME,mUserName)
                            intent.putExtra(Constants.CORRECT_ANSWER,mCorrectAnswer)
                            intent.putExtra(Constants.TOTAL_QUESTIONS, mQuestionList!!.size)
                            startActivity(intent)
                        }
                    }
                }
                else{
                    val question = mQuestionList?.get(mCurrentPosition-1)
                    if(question!!.correctAnswer != mSelectionOptionPosition){
                        answerView(mSelectionOptionPosition,R.drawable.wrong_item_bg,"#FF0505")
                    }else{
                        mCorrectAnswer++
                    }
                    answerView(question.correctAnswer,R.drawable.correct_item_bg,"#50F900")
                    if(mCurrentPosition == mQuestionList!!.size){
                        btn_submit.text = "Finish"
                    }
                    else{
                        btn_submit.text = "Next >>"
                    }
                    mSelectionOptionPosition = 0
                }
            }
        }
    }

    private fun answerView(answer: Int, drawbleView: Int, color : String) {
        when (answer) {
            1 -> {
                optionA.background = ContextCompat.getDrawable(this, drawbleView)
                optionA.setTextColor(Color.parseColor(color))
            }
            2 -> {
                optionB.background = ContextCompat.getDrawable(this, drawbleView)
                optionB.setTextColor(Color.parseColor(color))
            }
            3 -> {
                optionC.background = ContextCompat.getDrawable(this, drawbleView)
                optionC.setTextColor(Color.parseColor(color))
            }
            4 -> {
                optionD.background = ContextCompat.getDrawable(this, drawbleView)
                optionD.setTextColor(Color.parseColor(color))
            }
        }
    }

    private fun selectedOptionView(btn: Button, selectedOptionNum: Int) {
        defaultOptionsView()
        mSelectionOptionPosition = selectedOptionNum
        btn.background = ContextCompat.getDrawable(this, R.drawable.select_item_bg)
        btn.setTextColor(Color.parseColor("#2C86FD"))
    }
}