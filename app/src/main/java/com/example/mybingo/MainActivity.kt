package com.example.mybingo

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private var maxNumber: Int = 75
    private lateinit var maxNumberEditText: EditText
    private lateinit var registerMaxNumberButton: Button
    private lateinit var nextNumberButton: Button
    private lateinit var currentNumber: TextView
    private var recodesList = mutableListOf<Int>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        maxNumberEditText = findViewById(R.id.maxNumber)
        maxNumberEditText.setText("${this.maxNumber}")

        registerMaxNumberButton = findViewById(R.id.registerMaxNumber)
        registerMaxNumberButton.setOnClickListener {
            val maxNumberString = this.maxNumberEditText.text.toString()
            maxNumber = maxNumberString.toInt()

            Log.d("MainActivity", "maxNumber: $maxNumber")
        }

        nextNumberButton = findViewById(R.id.nextNumber)
        nextNumberButton.setOnClickListener {
            onClickNextNumber()
        }

        currentNumber = findViewById(R.id.currentNumber)
    }

//    override fun onClick(v: View?) {
//        val maxNumberString = this.maxNumberEditText.text.toString()
//        maxNumber = maxNumberString.toInt()
//
//        Log.d("MainActivity", "m axNumber: $maxNumber")
//    }

    private fun onClickNextNumber() {
        val randomNumber: Double = maxNumber * Math.random()
        val nextNumber: Int = createRandomNumber()

        Log.d("MainActivity", "maxNumber: $maxNumber")
        Log.d("MainActivity", "onClickNextNumber: $randomNumber")
        Log.d("MainActivity", nextNumber.toString())
        currentNumber.text = nextNumber.toString()

        recodesList.add(nextNumber)
        Log.d("MainActivity", "onClickNextNumber: $recodesList")
    }

    private fun createRandomNumber() : Int {
        val randomNumber: Double = maxNumber * Math.random()
        return randomNumber.toInt() + 1
    }
}