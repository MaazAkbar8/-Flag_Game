package com.example.flaggame

object constant {


    fun getQuestion(): ArrayList<Question>{
        val questionList=ArrayList<Question>()

        val q1=Question(1,"what country flage is this",R.drawable.australia,"australia","canada",
            "pak","france",1)
        val q2=Question(2,"what country flage is this",R.drawable.canada,"australia","maxico",
            "pak","canada",4)
        val q3=Question(3,"what country flage is this",R.drawable.pak,"france","us",
            "pak","canada",3)
        val q4=Question(4,"what country flage is this",R.drawable.european,"australia","european",
            "pak","canada",2)
        val q5=Question(5,"what country flage is this",R.drawable.germany,"germany","maxico",
            "pak","european",1)
        val q6=Question(6,"what country flage is this",R.drawable.mexico,"germany","maxico",
            "pak","european",2)
        val q7=Question(7,"what country flage is this",R.drawable.turkey,"germany","maxico",
            "turkey","european",3)
        val q8=Question(8,"what country flage is this",R.drawable.uk,"germany","maxico",
            "pak","uk",4)
        val q9=Question(9,"what country flage is this",R.drawable.us,"germany","us",
            "pak","european",2)
        val q10=Question(10,"what country flage is this",R.drawable.france,"germany","maxico",
            "france","european",3)



        questionList.add(q1)
        questionList.add(q2)
        questionList.add(q3)
        questionList.add(q4)
        questionList.add(q5)
        questionList.add(q6)
        questionList.add(q7)
        questionList.add(q8)
        questionList.add(q9)
        questionList.add(q10)

        return questionList
    }
}