package com.example.quizo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.quizo.databinding.ActivityErrorBinding

class ErrorActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        val binding:ActivityErrorBinding
        super.onCreate(savedInstanceState)
        binding= ActivityErrorBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.gobackbtn.setOnClickListener(View.OnClickListener {

            val intent=Intent(applicationContext,MainActivity::class.java)
            startActivity(intent)
            finish()

        })


    }
}