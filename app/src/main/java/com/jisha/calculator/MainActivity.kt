package com.jisha.calculator

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.jisha.calculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private var binding: ActivityMainBinding ?= null
    var isNewOp = true
    var oldNumber = ""
    var op = "+"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)

    }

    fun numberEvent(view: View) {
        if (isNewOp) {
            binding?.editText?.setText("")
        }
        isNewOp = false
        var btnClick = binding?.editText?.text.toString()
        when (view.id) {
            R.id.btn1 -> btnClick += "1"
            R.id.btn2 -> btnClick += "2"
            R.id.btn3 -> btnClick += "3"
            R.id.btn4 -> btnClick += "4"
            R.id.btn5 -> btnClick += "5"
            R.id.btn6 -> btnClick += "6"
            R.id.btn7 -> btnClick += "7"
            R.id.btn8 -> btnClick += "8"
            R.id.btn9 -> btnClick += "9"
            R.id.btn0 -> btnClick += "0"
            R.id.btnDot -> btnClick += "."
            R.id.btnPlusMinus -> btnClick = "-$btnClick"
        }
        binding?.editText?.setText(btnClick)
    }

    fun operatorEvent(view: View) {
        isNewOp = true
        oldNumber = binding?.editText?.text.toString()
        val btnSelect : Button = view as Button
        when (btnSelect.id) {
            R.id.btnPlus -> op = "+"
            R.id.btnMinus -> op = "-"
            R.id.btnMultiply -> op = "*"
            R.id.btnDivide -> op = "/"
        }
    }

    fun equalEvent(view: View) {
        val newNumber = binding?.editText?.text.toString()
        var result = 0.0
        when (op) {
            "+" -> result = oldNumber.toDouble() + newNumber.toDouble()
            "-" -> result = oldNumber.toDouble() - newNumber.toDouble()
            "*" -> result = oldNumber.toDouble() * newNumber.toDouble()
            "/" -> result = oldNumber.toDouble() / newNumber.toDouble()
        }
        binding?.editText?.setText(result.toString())
    }

    fun acEvent(view: View) {
        binding?.editText?.setText("0")
        isNewOp = true
    }

    fun percentageEvent(view: View) {
        val number = binding?.editText?.text.toString().toDouble() / 100
        binding?.editText?.setText(number.toString())
        isNewOp = true
    }
}