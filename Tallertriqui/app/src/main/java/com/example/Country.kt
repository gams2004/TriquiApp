package com.example

class Country(name: String, capital: String, nombreIng: String, sigla: String) {
    val name: String = name
    val capital: String = capital
    val nombreIng: String = nombreIng
    val sigla: String = sigla

    override fun toString(): String {
        return "$name"
    }
}
