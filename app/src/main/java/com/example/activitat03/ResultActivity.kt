package com.example.activitat03

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ResultActivity : AppCompatActivity() {
    // Variables declarados --> vD Start
    lateinit var bottonBack : Button
    lateinit var reCalculate : LinearLayout
    // vD End

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_result)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Vincular la variable con el ID --> vVI Start
        bottonBack = findViewById<Button>(R.id.aRBack)
        reCalculate = findViewById<LinearLayout>(R.id.aRReCalculate)
        // --> vVI End

        // Las funciones
        // LinearLayout --> Start
        reCalculate.setOnClickListener {
            var intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        // LinearLayout --> End

        // Buttons --> Start
        bottonBack.setOnClickListener {
            var intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        // Buttons --> End
    }
}