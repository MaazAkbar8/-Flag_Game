package com.example.flaggame.Screen

import android.annotation.SuppressLint
import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.flaggame.Question
import com.example.flaggame.R
import com.example.flaggame.constant
import com.example.flaggame.databinding.FragmentGameBinding


class GameF : Fragment(),View.OnClickListener{
    private lateinit var binding: FragmentGameBinding
    lateinit var mquestion :ArrayList<Question>

   private var  mselectedposition:Int=0
    private var mcorrectAnswer:Int=0
    private var mcurrentposition:Int=1

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding= DataBindingUtil.inflate(inflater,R.layout.fragment_game,container,false)


          // object class fun main fun call
         mquestion=constant.getQuestion()

 // event handling all option and btn

         binding.tvOptionOne.setOnClickListener(this)
        binding.tvOptionTwo.setOnClickListener(this)
        binding.tvOptionThree.setOnClickListener(this)
        binding.tvOptionFour.setOnClickListener(this)
        binding.btnSubmit.setOnClickListener(this)


                  setQuestion()






        return binding.root
    }

    @SuppressLint("SetTextI18n")
    private fun setQuestion(){
             // set question in all qusetion position
        val question:Question=mquestion[mcurrentposition -1]

        binding.tvQuestion.text=question.Question
        binding.imageView.setImageResource(question.image)
        binding.tvOptionOne.text=question.option1
        binding.tvOptionTwo.text=question.option2
        binding.tvOptionThree.text=question.option3
        binding.tvOptionFour.text=question.option4


          // this for progress bar set on own position
   binding.pb.progress=mcurrentposition
        binding.tvProgress.text="$mcurrentposition" + "/" + binding.pb.max //display qustion number

// main fuction appreance fun call
        defaultAppearance()


 //      all question fullfill then show "qiuz is finish" other wise show message "go to next Q"

        if (mcurrentposition==mquestion.size){
            binding.btnSubmit.text="Quiz finish"
        }else{
            binding.btnSubmit.text="submit"
        }


    }

    fun defaultAppearance(){
      // contrilling textview that share same behavior

           val options= ArrayList<TextView>()
         options.add(0,binding.tvOptionOne)
        options.add(1,binding.tvOptionTwo)
        options.add(2,binding.tvOptionThree)
        options.add(3,binding.tvOptionFour)



        for (option in options){



            option.setTextColor(Color.parseColor("#7A8089"))
            // DefaultAppearance

            option.typeface= Typeface.DEFAULT
            option.background= context?.let { ContextCompat.getDrawable(it,R.drawable.default_option_bg) }
        }






    }
 //  all option and btn event handling
    override fun onClick(v: View?) {
        when(v?.id){
            R.id.tv_optionOne ->{
                selectedOptionView(binding.tvOptionOne,1)




            }
            R.id.tv_optionTwo ->{

                selectedOptionView(binding.tvOptionTwo,2)
            }
            R.id.tv_optionThree ->{
                selectedOptionView(binding.tvOptionThree,3)

            }
            R.id.tv_optionFour ->{

                selectedOptionView(binding.tvOptionFour,4)
            }
            R.id.btnSubmit ->{

                // if user is not select options
                if (mselectedposition==0){

                    mcurrentposition++// when current position is increasing mean index is increasing
                    // if index is increasing that mean we will get sa new question in a list


                    //  if question is less then 10 setquestion fun calling but 10=10 show toast quiz finish
                    when {mcurrentposition <= mquestion.size->{

                        setQuestion()
                    }else->{

                        // go to result


                        val action =GameFDirections.actionGameFragmentToScoreFragment()
                        val nameOfPlayer by navArgs<GameFArgs>()
                        action.score= mcorrectAnswer
                        action.name = nameOfPlayer.name

                        findNavController().navigate(action)



                    }


                    }


                }else{
                    // if user select option then we will check correct or not

                     val ques=mquestion[mcurrentposition-1]

                      if (ques!!.correctAnswer!=mselectedposition){

                          answerView(mselectedposition,R.drawable.wrong_opton_border_bg)
                      } else {
                          mcorrectAnswer++

            // da ba landy oliky }
                          answerView(ques.correctAnswer, R.drawable.correct_option_border_bg)
//        10/10 then show messg finish
                          if (mcurrentposition == mquestion.size) {
                              binding.btnSubmit.text = "finish"

                              // otherwise show msg
                          } else {
                              binding.btnSubmit.text = "go to next question"
                          }
                      }// only show correct or wrong
                    mselectedposition=0 // next question option position position will be 0
                }

            }
        }
    }

    private fun selectedOptionView(tv: TextView, selectedPosition: Int) {
        //reset text view
           defaultAppearance()
          mselectedposition=selectedPosition

        tv.setTextColor(Color.parseColor("#363A43"))
        tv.setTypeface(tv.typeface, Typeface.BOLD)
        tv.background= context?.let { ContextCompat.getDrawable(it,R.drawable.default_option_bg) }
    }

    private fun answerView(mselectedposition: Int, drawableView: Int) {

        when(mselectedposition){

            1->{
                     binding.tvOptionOne.background=
                         context?.let { ContextCompat.getDrawable(it,drawableView) }
            }
            2->{
                binding.tvOptionTwo.background=
                    context?.let { ContextCompat.getDrawable(it,drawableView) }
            }
            3->{

                binding.tvOptionThree.background=
                    context?.let { ContextCompat.getDrawable(it,drawableView) }

            }

            4->{
                binding.tvOptionFour.background=
                    context?.let { ContextCompat.getDrawable(it,drawableView) }

            }



        }

    }

}






