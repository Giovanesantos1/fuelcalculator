package com.example.fuelcalculator

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_result)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val resultado = findViewById<TextView>(R.id.tv_result)
        val price = findViewById<TextView>(R.id.tv_resultPrice)
        val consumo = findViewById<TextView>(R.id.tv_resultConsumo)
        val distancia = findViewById<TextView>(R.id.tv_resultDistancia)
        val btnNovoCalculo = findViewById<Button>(R.id.btn_novoCalculo)

        val valor = intent.getStringExtra("valor")
        val consumoExtra = intent.getStringExtra("consumo")
        val km = intent.getStringExtra("km")
        val resultFinal = intent.getStringExtra("resultado")

        resultado.text = resultFinal
        price.text = valor
        consumo.text = consumoExtra
        distancia.text = km

        btnNovoCalculo.setOnClickListener {
            finish()
        }

    }
}