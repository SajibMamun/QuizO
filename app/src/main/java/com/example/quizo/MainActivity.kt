package com.example.quizo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.cncoderx.wheelview.OnWheelChangedListener
import com.example.quizo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {


    var topic:String?="Java"
    override fun onCreate(savedInstanceState: Bundle?) {
        var binding:ActivityMainBinding
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



        binding.topicwheel.onWheelChangedListener =
            OnWheelChangedListener { view, _, newIndex ->
                val text = view.getItem(newIndex)
                topic=text.toString()
            }


        binding.playbtnid.setOnClickListener(View.OnClickListener {



                var intent1=Intent(applicationContext,QuestionClassActivity::class.java)
                intent1.putExtra("subject",topic)
                startActivity(intent1)


        })
    }
}