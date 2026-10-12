package com.example.activitat03

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.button.MaterialButton
import com.google.android.material.card.MaterialCardView
import com.google.android.material.slider.Slider

class MainActivity : AppCompatActivity() {
    // Variables declarados --> vD Start
    var homeSelected: Boolean = false
    lateinit var cardHome : MaterialCardView
    lateinit var cardDona : MaterialCardView
    var weight = 170
    var age = 18
    lateinit var bottomWeightRemove : MaterialButton
    lateinit var bottomWeightAdd : MaterialButton
    lateinit var textWeight : TextView
    lateinit var bottomAgeAdd : MaterialButton
    lateinit var bottomAgeRemove : MaterialButton
    lateinit var textAge : TextView
    lateinit var textHeight : TextView
    lateinit var sHeight : Slider
    lateinit var calculate : LinearLayout
    // vD End

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Vincular la variable con el ID --> vVI Start
        cardHome = findViewById(R.id.aMSeleccio_home) // Male Option
        cardDona = findViewById(R.id.aMSeleccio_done) // Female Option

        bottomWeightAdd = findViewById(R.id.aMWeightAdd) // Button Add Weight
        bottomWeightRemove = findViewById(R.id.aMWeightRemove) // Button Remove Weight
        bottomAgeAdd = findViewById(R.id.aMAgeAdd) // Button Add Age
        bottomAgeRemove = findViewById(R.id.aMAgeRemove) // Button Remove Age
        calculate = findViewById(R.id.aMCalculate) // Button to calculate

        textWeight = findViewById(R.id.aMWeightText) // Weight Text
        textAge = findViewById(R.id.aMAgeText) // Age Text
        textHeight = findViewById(R.id.aMTextHeight) // Height Text

        sHeight = findViewById(R.id.aMSlHeight) // Slider
        // vVI End

        // Las funciones
        // Cards --> Start
        cardHome.setOnClickListener { // Male Card
            cardHome.setCardBackgroundColor(Color.rgb(173, 216, 230))
            cardDona.setCardBackgroundColor(Color.rgb(29, 30, 51))
            homeSelected = true
        }

        cardDona.setOnClickListener{ // Female Card
            cardDona.setCardBackgroundColor(Color.rgb(173, 216, 230))
            cardHome.setCardBackgroundColor(Color.rgb(29, 30, 51))
            homeSelected = false
        }
        // Cards --> End

        // Bottons --> Start
        bottomWeightAdd.setOnClickListener { // Weight Add Button
            weight+= 1
            textWeight.text = weight.toString()
        }

        bottomWeightRemove.setOnClickListener { // Weight Remove Button
            weight-= if (weight > 0) 1 else 0
            textWeight.text = weight.toString()
        }

        bottomAgeAdd.setOnClickListener { // Age Add Button
            age+= 1
            textAge.text = age.toString()
        }

        bottomAgeRemove.setOnClickListener { // Age Remove Button
            age-= if (age > 0) 1 else 0
            textAge.text = age.toString()
        }

        calculate.setOnClickListener {
            val intent = Intent(this, ResultActivity::class.java).apply {
                putExtra(ResultActivity.EXTRA_ALCADA, sHeight.value.toInt())
                putExtra(ResultActivity.EXTRA_PES, weight)
            }
            startActivity(intent)
        }
        // Bottons --> End

        // Slider --> Start
        sHeight.valueFrom = 0f // Height Slider Data
        sHeight.valueTo = 300f // Height Slider Data
        sHeight.stepSize = 1f // Height Slider Data
        sHeight.value = 73f // Height Slider Data
        
        sHeight.addOnChangeListener { _, value, _ ->  textHeight.text = value.toString() } // Height Slider - activity_Main
        // Slder --> End
    }
}