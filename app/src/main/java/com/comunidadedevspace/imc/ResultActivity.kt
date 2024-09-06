package com.comunidadedevspace.imc

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

const val KEY_RESULT_IMC = "ResultActivity.KEY_IMC"
class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val result = intent.getFloatExtra(KEY_RESULT_IMC, 0f)
        val tvResult = findViewById<TextView>(R.id.tv_result)
        val tvClassificacao = findViewById<TextView>(R.id.tv_classificacao)
        
        tvResult.text = result.toString()

        val (classificacao, color) = when{
            result < 18.5 -> "Magreza" to R.color.Magreza
            result in 18.5..24.9 -> "Normal" to R.color.Normal
            result in 25.0..29.9 -> "Sobrepeso" to R.color.Sobrepeso
            result in 30.0..39.9 -> "Obesidade" to R.color.Obesidade
            else -> "Obesidade" to R.color.Obesidade_grave

            }

        tvClassificacao.text = classificacao
        tvClassificacao.setTextColor(ContextCompat.getColor(this, color))

        }

    }
