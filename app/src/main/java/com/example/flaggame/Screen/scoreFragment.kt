package com.example.flaggame.Screen

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.addCallback
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import com.example.flaggame.R
import com.example.flaggame.databinding.FragmentScoreBinding


class ScoreF :androidx.fragment.app.Fragment() {

   // private lateinit var dispaly:TextView

    private lateinit var binding: FragmentScoreBinding


    @SuppressLint("SetTextI18n")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding= DataBindingUtil.inflate(inflater,R.layout.fragment_score,container,false)

//         display score to textview
       val scoreFArgs by navArgs<ScoreFArgs>()
        binding.displayResult.text="${scoreFArgs.name}! you have scored${scoreFArgs.score} points out of 10"
        Toast.makeText(context, "Mr.${scoreFArgs.name}! your total scored is ${scoreFArgs.score}out of 10", Toast.LENGTH_SHORT).show()




  //***************************************************************************************************************
// if user finish game playbutton repated game start
    binding.playAgain.setOnClickListener {
        view?.findNavController()?.navigate(R.id.action_scoreFragment3_to_titleF3)
    }
        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner) {


            view?.findNavController()?.navigate(R.id.action_scoreFragment3_to_titleF3)

        }

        return binding.root




    }

}


