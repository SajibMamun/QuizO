package com.example.quizo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.quizo.databinding.ActivityResultBinding

class ResultActivity : AppCompatActivity() {
    lateinit var binding:ActivityResultBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)



        val intent1=intent
       val result:String= intent1.getStringExtra("result").toString()
       val correct:String= intent1.getStringExtra("correct").toString()
       val incorrect:String= intent1.getStringExtra("wrong").toString()
       val skip:String= intent1.getStringExtra("skip").toString()

        binding.totalscortv.setText("Total Score: $result")
        binding.totalcorrecttv.setText("Correct: $correct")
        binding.totalIncorrecttv.setText("Wrong: $incorrect")
        binding.totalskiptv.setText("Skip: $skip")

        binding.playagainbtn.setOnClickListener {

            val intent2= Intent(applicationContext,MainActivity::class.java)
            startActivity(intent2)
        }
    }
}