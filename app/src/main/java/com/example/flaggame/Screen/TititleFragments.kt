package com.example.flaggame.Screen

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.flaggame.R
import com.example.flaggame.databinding.FragmentTitleBinding


class TitleF : Fragment() {


    private lateinit var binding: FragmentTitleBinding

    @SuppressLint("SuspiciousIndentation")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_title, container, false)




        binding.btnStart.setOnClickListener { view:View->

                    // if edittext is empty to show toast other wise go to another fragment
                if (binding.etName.text!!.isNotEmpty()){

                    // val i = Intent(context,GameF::class.java)

                   // startActivity(i)
                     val action= TitleFDirections.actionTitleFragmentToGameFragment()
                    action.name=binding.etName.text.toString()

                    findNavController().navigate(action)

                }else{

                    Toast.makeText(context, "please enter your name", Toast.LENGTH_SHORT).show()

                }
            }
        return binding.root
    }
}