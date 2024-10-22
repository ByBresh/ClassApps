package com.example.classapps.IMCapp

import android.content.Intent
import android.icu.text.DecimalFormat
import android.icu.text.DecimalFormatSymbols
import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.classapps.R
import com.google.android.material.slider.RangeSlider
import java.lang.Math.pow

class IMCActivity : AppCompatActivity() {

    private var isMaleSelected: Boolean = true
    private var isFemaleSelected: Boolean = false
    private var currentWeight: Int = 60
    private var currentAge: Int = 30
    private var currentHeight: Int = 120

    private lateinit var viewMale: CardView
    private lateinit var viewFemale: CardView
    private lateinit var tvHeight: TextView
    private lateinit var rsHeight: RangeSlider
    private lateinit var tvWeight: TextView
    private lateinit var btnSubtractWeight: CardView
    private lateinit var btnAddWeight: CardView
    private lateinit var tvAge: TextView
    private lateinit var btnSubtractAge: CardView
    private lateinit var btnAddAge: CardView
    private lateinit var btnCalculate: CardView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_imc)

        initComponents()
        initListeners()
    }

    private fun initComponents() {
        viewMale = findViewById(R.id.viewMale)
        viewFemale = findViewById(R.id.viewFemale)
        tvHeight = findViewById(R.id.tvHeight)
        rsHeight = findViewById(R.id.rsHeight)
        tvWeight = findViewById(R.id.tvWeight)
        btnSubtractWeight = findViewById(R.id.cvSubstractWeight)
        btnAddWeight = findViewById(R.id.cvAddWeight)
        tvAge = findViewById(R.id.tvAge)
        btnAddAge = findViewById(R.id.cvAddAge)
        btnSubtractAge = findViewById(R.id.cvSubstractAge)
        btnCalculate = findViewById(R.id.cvCalculate)
    }

    private fun initListeners() {
        viewMale.setOnClickListener { setComponentColorMale() }
        viewFemale.setOnClickListener { setComponentColorFemale() }
        rsHeight.addOnChangeListener { _, value, _ ->
            val df = DecimalFormat("#")
            currentHeight = df.format(value).toInt()
            tvHeight.text = "$currentHeight cm"
        }
        btnAddWeight.setOnClickListener {
            currentWeight++
            tvWeight.text = currentWeight.toString()
        }
        btnSubtractWeight.setOnClickListener {
            currentWeight--
            tvWeight.text = currentWeight.toString()
        }
        btnAddAge.setOnClickListener {
            currentAge++
            tvAge.text = currentAge.toString()
        }
        btnSubtractAge.setOnClickListener {
            currentAge--
            tvAge.text = currentAge.toString()
        }
        btnCalculate.setOnClickListener {
            btnCalculate.setCardBackgroundColor(getColor(R.color.background_button))
            Thread.sleep(200)
            btnCalculate.setCardBackgroundColor(getColor(R.color.background_fab))
            val result = calculateIMC()
            navigateToResult(result)
        }
    }

    private fun navigateToResult(result: Double) {
        val intent = Intent(this, ResultActivity::class.java)
        intent.putExtra("extra_result", result)
        startActivity(intent)
    }

    private fun calculateIMC(): Double {
        val dfs = DecimalFormatSymbols()
        dfs.decimalSeparator = '.'
        val df = DecimalFormat("#.##")
        df.decimalFormatSymbols = dfs
        val imc: Double = currentWeight / pow(currentHeight.toDouble() /100, 2.0)
        return df.format(imc).toDouble()
    }

    private fun setComponentColorMale() {
        if (!isMaleSelected) {
            viewMale.setBackgroundColor(getColor(R.color.background_component_selected))
            viewFemale.setBackgroundColor(getColor(R.color.background_component))
            isMaleSelected = true
            isFemaleSelected = false
        }
    }

    private fun setComponentColorFemale() {
        if (!isFemaleSelected) {
            viewFemale.setBackgroundColor(getColor(R.color.background_component_selected))
            viewMale.setBackgroundColor(getColor(R.color.background_component))
            isMaleSelected = false
            isFemaleSelected = true
        }
    }
}
