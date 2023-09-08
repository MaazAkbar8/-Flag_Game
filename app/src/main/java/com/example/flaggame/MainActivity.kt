package com.example.flaggame

import android.content.Context
import android.content.Intent
import android.os.Build.VERSION_CODES.R
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.databinding.DataBindingUtil
import androidx.databinding.DataBindingUtil.*
import androidx.databinding.ViewDataBinding
import com.example.flaggame.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
   lateinit var dataBinding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dataBinding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(dataBinding.root)

       // val binding: ViewDataBinding? = DataBindingUtil.setContentView(this, R.layout  . activity_main)

      // val playAgain=findViewById<Button>(R.id.playAgain)

        // Event handler
       // playAgain.setOnClickListener {
           // val i=Intent(this, game::class.java)

       // }



    }
}