package com.example.tallertriqui

import android.R
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import com.example.tallertriqui.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    val languages = arrayOf("Español", "Inglés", "Francés", "Italiano", "Portugués")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapter = ArrayAdapter<String>(this, R.layout.simple_list_item_1, languages)
        binding.LanguageSpinner.adapter = adapter

        binding.TicButton.setOnClickListener{
            startActivity((Intent(baseContext, TicTacToeActivity::class.java)))
        }

        binding.greetButton.setOnClickListener{
            val intent = Intent(this, GreetActivity::class.java)
            intent.putExtra("language", binding.LanguageSpinner.selectedItem.toString())
            startActivity(intent)
        }

        binding.countriesButton.setOnClickListener{
            startActivity(Intent(baseContext, ListActivity::class.java))
        }
    }
}