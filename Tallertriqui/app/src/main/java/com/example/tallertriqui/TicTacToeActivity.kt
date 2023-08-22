package com.example.tallertriqui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.core.content.ContextCompat
import com.example.tallertriqui.databinding.ActivityTicTacToeBinding

class TicTacToeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTicTacToeBinding
    private var turno = true
    private var ganador = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTicTacToeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button1.setOnClickListener {ponerFicha(binding.button1)}
        binding.button2.setOnClickListener {ponerFicha(binding.button2)}
        binding.button3.setOnClickListener {ponerFicha(binding.button3)}
        binding.button4.setOnClickListener {ponerFicha(binding.button4)}
        binding.button5.setOnClickListener {ponerFicha(binding.button5)}
        binding.button6.setOnClickListener {ponerFicha(binding.button6)}
        binding.button7.setOnClickListener {ponerFicha(binding.button7)}
        binding.button8.setOnClickListener {ponerFicha(binding.button8)}
        binding.button9.setOnClickListener {ponerFicha(binding.button9)}
        binding.newGameButton.setOnClickListener {newGame()}

    }

    fun ponerFicha(but: Button){
        if(!ganador)
            if(but.text==" "){
                if (turno) but.text = "X"
                if (!turno) but.text = "O"
                turno = !turno
                winnerCheck()
            }
    }
    fun newGame(){
        binding.button1.text = " "
        binding.button2.text = " "
        binding.button3.text = " "
        binding.button4.text = " "
        binding.button5.text = " "
        binding.button6.text = " "
        binding.button7.text = " "
        binding.button8.text = " "
        binding.button9.text = " "
        binding.ganadorText.text = " "
        binding.button1.backgroundTintList = getColorStateList(android.R.color.holo_purple)
        binding.button2.backgroundTintList = getColorStateList(android.R.color.holo_purple)
        binding.button3.backgroundTintList = getColorStateList(android.R.color.holo_purple)
        binding.button4.backgroundTintList = getColorStateList(android.R.color.holo_purple)
        binding.button5.backgroundTintList = getColorStateList(android.R.color.holo_purple)
        binding.button6.backgroundTintList = getColorStateList(android.R.color.holo_purple)
        binding.button7.backgroundTintList = getColorStateList(android.R.color.holo_purple)
        binding.button8.backgroundTintList = getColorStateList(android.R.color.holo_purple)
        binding.button9.backgroundTintList = getColorStateList(android.R.color.holo_purple)
        ganador = false
    }

    fun winnerCheck(){
        //Caso horizontal primera fila
        if(binding.button1.text==binding.button2.text && binding.button2.text == binding.button3.text)
            if(binding.button1.text != " " && binding.button2.text != " " && binding.button3.text != " ") {
                toGreen(binding.button1,binding.button2,binding.button3)
                if (turno) binding.ganadorText.text = "PLAYER TWO WINS"
                else binding.ganadorText.text = "PLAYER ONE WINS"
                ganador = true
            }

        //Caso horizontal segunda fila
        if(binding.button4.text==binding.button5.text && binding.button5.text == binding.button6.text)
            if(binding.button4.text != " " && binding.button5.text != " " && binding.button6.text != " ") {
                toGreen(binding.button4,binding.button5,binding.button6)
                if (turno) binding.ganadorText.text = "PLAYER TWO WINS"
                else binding.ganadorText.text = "PLAYER ONE WINS"
                ganador = true
            }

        //Caso horizontal tercera fila
        if(binding.button7.text==binding.button8.text && binding.button8.text == binding.button9.text)
            if(binding.button7.text != " " && binding.button8.text != " " && binding.button9.text != " ") {
                toGreen(binding.button7,binding.button8,binding.button9)
                if (turno) binding.ganadorText.text = "PLAYER TWO WINS"
                else binding.ganadorText.text = "PLAYER ONE WINS"
                ganador = true
            }


        //Caso vertical primera columna
        if(binding.button1.text==binding.button4.text && binding.button4.text == binding.button7.text)
            if(binding.button1.text != " " && binding.button4.text != " " && binding.button7.text != " ") {
                toGreen(binding.button1,binding.button4,binding.button7)
                if (turno) binding.ganadorText.text = "PLAYER TWO WINS"
                else binding.ganadorText.text = "PLAYER ONE WINS"
                ganador = true
            }

        //Caso vertical segunda columna
        if(binding.button2.text==binding.button5.text && binding.button5.text == binding.button8.text)
            if(binding.button2.text != " " && binding.button5.text != " " && binding.button8.text != " ") {
                toGreen(binding.button2,binding.button5,binding.button8)
                if (turno) binding.ganadorText.text = "PLAYER TWO WINS"
                else binding.ganadorText.text = "PLAYER ONE WINS"
                ganador = true
            }

        //Caso vertical segunda columna
        if(binding.button3.text==binding.button6.text && binding.button6.text == binding.button9.text)
            if(binding.button3.text != " " && binding.button6.text != " " && binding.button9.text != " ") {
                toGreen(binding.button3,binding.button6,binding.button9)
                if (turno) binding.ganadorText.text = "PLAYER TWO WINS"
                else binding.ganadorText.text = "PLAYER ONE WINS"
                ganador = true
            }


        //Caso diagonal negativo
        if(binding.button1.text==binding.button5.text && binding.button5.text == binding.button9.text)
            if(binding.button1.text != " " && binding.button5.text != " " && binding.button9.text != " ") {
                toGreen(binding.button1,binding.button5,binding.button9)
                if (turno) binding.ganadorText.text = "PLAYER TWO WINS"
                else binding.ganadorText.text = "PLAYER ONE WINS"
                ganador = true
            }

        //Caso diagonal positivo
        if(binding.button7.text==binding.button5.text && binding.button5.text == binding.button3.text)
            if(binding.button7.text != " " && binding.button5.text != " " && binding.button3.text != " ") {
                toGreen(binding.button7,binding.button5,binding.button3)
                if (turno) binding.ganadorText.text = "PLAYER TWO WINS"
                else binding.ganadorText.text = "PLAYER ONE WINS"
                ganador = true
            }
    }

    fun toGreen(but1: Button, but2: Button, but3: Button){
        but1.backgroundTintList = getColorStateList(android.R.color.holo_green_light)
        but2.backgroundTintList = getColorStateList(android.R.color.holo_green_light)
        but3.backgroundTintList = getColorStateList(android.R.color.holo_green_light)
    }

}