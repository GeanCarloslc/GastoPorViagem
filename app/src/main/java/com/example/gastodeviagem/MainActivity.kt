package com.example.gastodeviagem

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.NumberFormatException

class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnCalcularKm.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        val id = view.id
        if (id == R.id.btnCalcularKm) {
            calcularKm()
        }
    }

    private fun calcularKm() {
        if (validacaoOK()) {
            try {
                val distancia = editDistancia.text.toString().toDouble()
                val preco = editPreco.text.toString().toDouble()
                val autonomia = editAutonomia.text.toString().toDouble()

                val vlTotal = (distancia * preco) / autonomia
                textVlTotal.text = "R$ ${"%.2f".format(vlTotal)}"
            } catch (nfe: NumberFormatException) {
                Toast.makeText(
                    applicationContext,
                    getString(R.string.informe_valores_validos),
                    Toast.LENGTH_LONG
                ).show()
            }

        } else {
            Toast.makeText(
                applicationContext,
                getString(R.string.preencha_todos_os_campos),
                Toast.LENGTH_LONG
            ).show()
        }
    }

    private fun validacaoOK(): Boolean {
        return (editDistancia.text.toString() != ""
                && editPreco.text.toString() != ""
                && editAutonomia.text.toString() != "")
    }
}