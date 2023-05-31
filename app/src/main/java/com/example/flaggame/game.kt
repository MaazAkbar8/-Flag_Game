package com.example.flaggame

import android.content.Intent
import android.database.DatabaseUtils
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button


class game : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)

        val submit=findViewById<Button>(R.id.btnSubmit)

        submit.setOnClickListener {

            val i=Intent(this,MainActivity::class.java)
            startActivity(i)
        }


    }
}