package com.example.mybingo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private var maxNumber: Int = 75
    private lateinit var maxNumberEditText: EditText
    private lateinit var registerMaxNumberButton: Button
    private lateinit var nextNumberButton: Button
    private lateinit var currentNumber: TextView
    private var history = mutableListOf<Int>()
    private lateinit var historyTextView: TextView

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

        historyTextView = findViewById(R.id.history)
    }

    private fun onClickNextNumber() {

        var nextNumber: Int = createRandomNumber()
        while (history.contains(nextNumber)) {
            Log.d("MainActivity", "重複したので再生成")
            nextNumber = createRandomNumber()
        }

        val nextNumberString = nextNumber.toString()
        Log.d("MainActivity", "maxNumber: $maxNumber")
        Log.d("MainActivity", nextNumberString)

        currentNumber.text = nextNumberString

        history.add(nextNumber)
        Log.d("MainActivity", "onClickNextNumber: $history")

        historyTextView.text = history.toString()
    }

    private fun createRandomNumber() : Int {
        val randomNumber: Double = maxNumber * Math.random()
        return randomNumber.toInt() + 1
    }
}