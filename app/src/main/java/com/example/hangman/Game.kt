package com.example.hangman

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

import kotlinx.android.synthetic.main.content_game.*
import kotlin.random.Random

class Game : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)

        var charList : ArrayList<Char> = arrayListOf('P','D','T')
        //wstepna baza slow
        val listaSlow : ArrayList<String> = arrayListOf("Pierwszy", "Drugi", "Trzeci")

        //Ustawienie obrazku
        gameImage.setImageResource(R.drawable.volkswagen)

        //Ustawienie pierwszego slowa
        gameTextView.text = ukrywanieSlowa(setWord(listaSlow),charList)

        // Obsluga button click
        gameButton.setOnClickListener { gameTextView.text = ukrywanieSlowa(setWord(listaSlow),charList)}
    }

    private fun randomNumber (lista : ArrayList<String>) :Int{
        return Random.nextInt(0,lista.size)
    }

    private fun setWord (lista: ArrayList<String>) :String{
        return lista[Random.nextInt(0,lista.size)]
    }

    private fun ukrywanieSlowa (word:String, charList:ArrayList<Char> ):String{
        var second = ""

        for (singleChar in word.toUpperCase()){
            when {
                charList.contains(singleChar) -> {second+=singleChar}
                singleChar.isWhitespace() -> second+=" "
                else -> second+=("_")
            }
        }
        return second
    }

}
