package com.example.tallertriqui

import android.R
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.TextView
import com.example.Country
import com.example.tallertriqui.databinding.ActivityListBinding
import org.json.JSONObject

class ListActivity : AppCompatActivity() {
    private lateinit var binding: ActivityListBinding
    private var countries = mutableListOf<Country>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListBinding.inflate(layoutInflater)
        setContentView(binding.root)
        loadCountries()
        val adapter = ArrayAdapter<Country>(this, R.layout.simple_list_item_1, countries)
        binding.listView.adapter = adapter

        binding.listView.setOnItemClickListener{parent, v, p, id ->
            val intent = Intent(this, PaisActivity::class.java)
            intent.putExtra("nombre", countries.get(p).name)
            intent.putExtra("name", countries.get(p).nombreIng)
            intent.putExtra("capital", countries.get(p).capital)
            intent.putExtra("sigla", countries.get(p).sigla)
            startActivity(intent)
        }
    }

    fun loadCountries(){
        val json_string = this.assets.open("paises.json").bufferedReader().use {
            it.readText()
        }
        var json = JSONObject(json_string);
        var paisesJsonArray = json.getJSONArray("paises");
        for (i in 0 until paisesJsonArray.length()-1) {
            val jsonObject = paisesJsonArray.getJSONObject(i)
            val capital = jsonObject.getString("capital")
            val name = jsonObject.getString("nombre_pais")
            val nombreIng = jsonObject.getString("nombre_pais_int")
            val sigla = jsonObject.getString("sigla")

            //Crear el objeto pais y agregarlo al arreglo
            val country = Country(name, capital, nombreIng, sigla)
            countries.add(country)
        }
    }
}