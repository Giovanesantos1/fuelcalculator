package com.example.fuelcalculator

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val valor = findViewById<EditText>(R.id.edt_preço)
        val consumo = findViewById<EditText>(R.id.edt_consumo)
        val km = findViewById<EditText>(R.id.edt_distancia)
        val resultado = findViewById<Button>(R.id.btn_calcular)

        }
    }
