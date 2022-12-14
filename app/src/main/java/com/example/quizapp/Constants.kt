package com.example.quizapp

object Constants {
    const val USER_NAME : String = "user_name"
    const val TOTAL_QUESTIONS : String  = "total_questions"
    const val CORRECT_ANSWER : String = "correct_answers"
    fun getQuestion(): ArrayList<Question> {
        val questionList = ArrayList<Question>()
        val ques1 = Question(
            1, "What Country does this flag belong to?",
            R.drawable.ic_flag_of_argentina,
            "Argentina",
            "Australia",
            "Armenia",
            "Austria",
            1
        )
        questionList.add(ques1)

        val ques2 = Question(
            2, "What Country does this flag belong to?",
            R.drawable.ic_flag_of_australia,
            "Angola",
            "Austria",
            "Australia",
            "Armenia",
            3
        )
        questionList.add(ques2)

        val ques3 = Question(
            3, "What Country does this flag belong to?",
            R.drawable.ic_flag_of_brazil,
            "Belarus",
            "Belize",
            "Brunei",
            "Brazil",
            4
        )
        questionList.add(ques3)

        val ques4 = Question(
            4, "What Country does this flag belong to?",
            R.drawable.ic_flag_of_belgium,
            "Bahamas",
            "Belgium",
            "Barbados",
            "Belize",
            2
        )
        questionList.add(ques4)

        val ques5 = Question(
            5, "What Country does this flag belong to?",
            R.drawable.ic_flag_of_fiji,
            "Gabon",
            "France",
            "Fiji",
            "Finland",
            3
        )
        questionList.add(ques5)

        val ques6 = Question(
            6, "What Country does this flag belong to?",
            R.drawable.ic_flag_of_germany,
            "Germany",
            "Georgia",
            "Greece",
            "none of these",
            1
        )
        questionList.add(ques6)

        val ques7 = Question(
            7, "What Country does this flag belong to?",
            R.drawable.ic_flag_of_denmark,
            "Dominica",
            "Egypt",
            "Denmark",
            "Austria",
            3
        )
        questionList.add(ques7)

        val ques8 = Question(
            8, "What Country does this flag belong to?",
            R.drawable.ic_flag_of_india,
            "Ireland",
            "Iran",
            "Hungry",
            "India",
            4
        )
        questionList.add(ques8)

        val ques9 = Question(
            9, "What Country does this flag belong to?",
            R.drawable.ic_flag_of_new_zealand,
            "Australia",
            "New Zealand",
            "Tuvalu",
            "United States of America",
            2
        )
        questionList.add(ques9)

        val ques10 = Question(
            10, "What Country does this flag belong to?",
            R.drawable.ic_flag_of_kuwait,
            "Kuwait",
            "Jordan",
            "Sudan",
            "Palestine",
            1
        )
        questionList.add(ques10)
        return questionList
    }
}