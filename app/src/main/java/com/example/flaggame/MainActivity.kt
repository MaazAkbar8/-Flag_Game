package com.example.flaggame

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val playAgain=findViewById<Button>(R.id.playAgain)

        // Event handler
        playAgain.setOnClickListener {
            val i=Intent(this,game::class.java)
            startActivity(i)
        }



    }
}