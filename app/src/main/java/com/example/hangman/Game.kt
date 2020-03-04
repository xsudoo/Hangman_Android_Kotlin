package com.example.hangman

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.content_game.*
import kotlin.random.Random

class Game : AppCompatActivity() {
    private var gameScore = 0
    private var missShot = 0
    private val listaSlow: ArrayList<String> = arrayListOf("Pierwszy", "Drugi", "Trzeci")
    private var charList: ArrayList<Char> = arrayListOf()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)


        //wstepna baza slow

        val slowo = setWord(listaSlow)
        //Ustawienie obrazku
        gameImage.setImageResource(R.drawable.volkswagen)

        //Ustawienie pierwszego slowa
        gameTextView.text = wyswietlanie(ukrywanieSlowa(slowo, charList))

        // Obsluga button click
        gameButton.setOnClickListener {
            val singleChar: Char = gameEditText.text.toString()[0].toUpperCase()
            charList.add(singleChar)

            if (czyTrafil(singleChar, slowo)) {
                gameTextView.text = wyswietlanie(ukrywanieSlowa(slowo, charList))
                gameImage.setImageResource(R.drawable.volkswagen)
            } else {gameImage.setImageResource(R.drawable.star)
            missShot++}

        }
    }

    private fun setWord(lista: ArrayList<String>): String {
        return lista[Random.nextInt(0, lista.size)].toUpperCase()
    }

    private fun ukrywanieSlowa(word: String, charList: ArrayList<Char>): String {
        var second = ""

        for (singleChar in word) {
            when {
                charList.contains(singleChar) -> {
                    second += singleChar
                }
                singleChar.isWhitespace() -> second += " "
                else -> second += ("_")

            }

        }
        gameScore++
        return second
    }

    private fun wyswietlanie(word: String): String {
        var trzecie = ""

        for (single in word) {
            trzecie += "$single "
        }

        return trzecie
    }

    private fun czyTrafil(singleChar: Char, word: String): Boolean {

        return word.contains(singleChar)    }

}
