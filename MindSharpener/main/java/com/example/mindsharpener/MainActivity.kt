package com.example.mindsharpener

import android.os.Bundle
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.util.*

class MainActivity : AppCompatActivity() {
    private lateinit var radioGroup: RadioGroup
    private lateinit var firstNumberTextView: TextView
    private lateinit var operatorTextView: TextView
    private lateinit var secondNumberTextView: TextView
    private lateinit var userAnswerTextView: EditText
    private var firstNumber: Int = 0
    private var secondNumber: Int = 0
    private var operator: String = ""
    private var point: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        radioGroup = findViewById(R.id.radioGroup)
        firstNumberTextView = findViewById(R.id.textView3)
        operatorTextView = findViewById(R.id.textView4)
        secondNumberTextView = findViewById(R.id.textView5)
        userAnswerTextView = findViewById(R.id.editText)

        radioGroup.setOnCheckedChangeListener { _, checkedId ->
            val random = Random()
            when (checkedId) {
                R.id.radioButton -> {
                    firstNumber = random.nextInt(10)
                    secondNumber = random.nextInt(10)
                }
                R.id.radioButton2 -> {
                    firstNumber = random.nextInt(100)
                    secondNumber = random.nextInt(100)
                }
                R.id.radioButton3 -> {
                    firstNumber = random.nextInt(1000)
                    secondNumber = random.nextInt(1000)
                }
            }
            val operatorNumber = random.nextInt(4)
            when (operatorNumber) {
                0 -> operator = "+"
                1 -> operator = "-"
                2 -> operator = "*"
                3 -> operator = "/"
            }
            firstNumberTextView.text = firstNumber.toString()
            operatorTextView.text = operator
            secondNumberTextView.text = secondNumber.toString()
        }
        findViewById<TextView>(R.id.button).setOnClickListener {
            val userAnswer = userAnswerTextView.text.toString().toDouble()
            val calculatedAnswer = when (operator) {
                "+" -> firstNumber + secondNumber
                "-" -> firstNumber - secondNumber
                "*" -> firstNumber * secondNumber
                "/" -> firstNumber / secondNumber
                else -> 0.0
            }
            if (userAnswer == calculatedAnswer) {
                point++
            } else {
                point--
            }
            userAnswerTextView.text = null
            findViewById<TextView>(R.id.textView8).text = point.toString()
        }
    }
}
