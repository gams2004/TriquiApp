package com.example.tallertriqui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tallertriqui.databinding.ActivityPaisBinding

class PaisActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPaisBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPaisBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.nombre.text = intent.getStringExtra("nombre")
        binding.nombreIng.text = intent.getStringExtra("name")
        binding.capital.text = intent.getStringExtra("capital")
        binding.sigla.text = intent.getStringExtra("sigla")
    }
}