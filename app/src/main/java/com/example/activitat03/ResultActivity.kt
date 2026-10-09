package com.example.activitat03

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ResultActivity : AppCompatActivity() {
    // Variables declarados --> vD Start
    lateinit var bottonBack : Button
    lateinit var reCalculate : LinearLayout
    var alcada = 0
    var pes = 0
    lateinit var resultText : TextView
    lateinit var largeResult : TextView
    lateinit var smallResult : TextView
    // vD End

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_result)

        alcada = intent.getIntExtra(EXTRA_ALCADA, 0)
        pes = intent.getIntExtra(EXTRA_PES, 0)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Vincular la variable con el ID --> vVI Start
        bottonBack = findViewById(R.id.aRBack)
        reCalculate = findViewById(R.id.aRReCalculate)
        resultText = findViewById(R.id.aRResult)
        largeResult = findViewById(R.id.aRLargeResult)
        smallResult = findViewById(R.id.aRSmallResult)
        // --> vVI End

        // Operaciones --> ops Start
        val alcadaMetro = alcada/100.0
        val result = pes / (alcadaMetro * alcadaMetro)
        resultText.text = String.format("%.2f", result)

        if (result < 18.5) {
            largeResult.text = "BAJO"
            smallResult.text = "Bajo"
        } else if (result in 18.5..24.9) {
            largeResult.text = "NORMAL"
            smallResult.text = "Normal"
        } else if (result in 25.0 .. 29.9) {
            largeResult.text = "SOBREPESO"
            smallResult.text = "Sobrepeso"
        } else {
            largeResult.text = "OBESIDAD"
            smallResult.text = "Obesidad"
        }
        // ops --> End

        // Las funciones
        // LinearLayout --> Start
        reCalculate.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        // LinearLayout --> End

        // Buttons --> Start
        bottonBack.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        // Buttons --> End
    }

    companion object {
        const val EXTRA_ALCADA = "extra_alcada"
        const val EXTRA_PES = "extra_pes"
    }
}