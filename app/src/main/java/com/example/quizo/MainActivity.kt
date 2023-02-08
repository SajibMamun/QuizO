package com.example.quizo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.cncoderx.wheelview.OnWheelChangedListener
import com.example.quizo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {


    var topic:String?=null
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
    }
}