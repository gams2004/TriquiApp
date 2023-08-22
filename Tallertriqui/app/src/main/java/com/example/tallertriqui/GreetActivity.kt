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
        binding.saludo.text = intent.getStringExtra("language")
        when(intent.getStringExtra("language")){
            "Español" -> binding.saludo.text = "Buenas buenas"
            "Inglés" -> binding.saludo.text = "'sup, how's it going?"
            "Francés" -> binding.saludo.text = "Bonjour, comment allez-vous?"
            "Italiano" -> binding.saludo.text = "Ciao, come stai?"
            "Portugués" -> binding.saludo.text = "Como você está garoto?"
        }

    }
}