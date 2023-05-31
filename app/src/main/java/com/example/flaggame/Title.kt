package com.example.flaggame

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Title : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_title)

        val btn=findViewById<Button>(R.id.btnstart)


        btn.setOnClickListener {
        val i=Intent(this,game::class.java)
        startActivity(i)


    }
}

}