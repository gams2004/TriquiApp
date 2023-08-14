package com.example.tallertriqui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tallertriqui.databinding.ActivityGreetBinding
import com.example.tallertriqui.databinding.ActivityMainBinding

class GreetActivity : AppCompatActivity() {
    private lateinit var binding: ActivityGreetBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGreetBinding.inflate(layoutInflater)
        setContentView(binding.root)


    }
}