package com.example.tallertriqui

import android.R
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import com.example.Country
import com.example.tallertriqui.databinding.ActivityListBinding
import org.json.JSONObject

class ListActivity : AppCompatActivity() {
    private lateinit var binding: ActivityListBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var countries = loadCountries()
        loadCountries()
        val adapter = ArrayAdapter<Country>(this, R.layout.simple_list_item_1, countries)
        binding.listView.adapter = adapter

    }

    fun loadCountries(): Array<Country> {
        var countriesAux =  mutableListOf<Country>()
        val json_string = this.assets.open("paises.json").bufferedReader().use {
            it.readText()
        }
        var json = JSONObject(json_string);
        var paisesJsonArray = json.getJSONArray("paises");
        for (i in 0 until paisesJsonArray.length()) {
            val jsonObject = paisesJsonArray.getJSONObject(i)
            val capital = jsonObject.getString("capital")
            val name = jsonObject.getString("nombre_pais")
//Crear el objeto pais y agregarlo al arreglo
            val country = Country(name, capital)
            countriesAux.add(country)
        }
        val countries = countriesAux.toTypedArray()
        return countries
    }
}