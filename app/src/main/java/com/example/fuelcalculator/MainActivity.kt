package com.example.fuelcalculator

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val edtvalor = findViewById<EditText>(R.id.edt_preço)
        val edtconsumo = findViewById<EditText>(R.id.edt_consumo)
        val edtkm = findViewById<EditText>(R.id.edt_distancia)
        val btncalcular = findViewById<Button>(R.id.btn_calcular)

        btncalcular.setOnClickListener {
            val valorStr: String = edtvalor.text.toString()
            val consumoStr: String = edtconsumo.text.toString()
            val kmStr: String= edtkm.text.toString()

            if (valorStr == "" || consumoStr == "" || kmStr == ""){
                Snackbar.make(edtvalor, "Preencha todos os campos", Snackbar.LENGTH_LONG).show()
            }
            else{
                val valor = valorStr.toFloat()
                val consumo = consumoStr.toFloat()
                val km = kmStr.toFloat()

                val resultado = if (consumo != 0f) {
                    (km / consumo) * valor

                } else {
                    0f
                }
                    val intent = Intent(this, ResultActivity::class.java)
                    intent.putExtra("valor", valor.toString())
                    intent.putExtra("consumo", consumo.toString())
                    intent.putExtra("km", km.toString())
                    intent.putExtra("resultado", resultado.toString())
                    startActivity(intent)
            }
        }


    }
}
