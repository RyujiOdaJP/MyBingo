package com.example.mybingo

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private var maxNumber: Int = 75
    private lateinit var maxNumberEditText: EditText
    private lateinit var registerMaxNumberButton: Button


//    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        maxNumberEditText = findViewById(R.id.maxNumber)
        registerMaxNumberButton = findViewById(R.id.registerMaxNumber)
        registerMaxNumberButton.setOnClickListener(this)

        maxNumberEditText.setText("${this.maxNumber}")
    }

    override fun onClick(v: View?) {
        val maxNumberString = this.maxNumberEditText.text.toString()
        maxNumber = maxNumberString.toInt()

        Log.d("MainActivity", "maxNumber: $maxNumber")



    }
}