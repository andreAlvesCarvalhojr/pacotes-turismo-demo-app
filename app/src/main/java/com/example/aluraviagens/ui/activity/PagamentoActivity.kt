package com.example.aluraviagens.ui.activity

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.example.aluraviagens.R
import com.example.aluraviagens.model.Pacote
import com.example.aluraviagens.util.MoedaUtil

class PagamentoActivity : AppCompatActivity(), View.OnClickListener {
    companion object {
        private const val EXTRA_PACOTE = "pacote"
        var pacote: Pacote? = null
    }

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pagamento)

        title = "Pagamento"

        pacote = intent.getSerializableExtra(EXTRA_PACOTE) as Pacote
        findViewById<TextView>(R.id.pagamento_preco_pacote).text = mostrarPreco(pacote!!).toString()


        val botaoFinalizarCompra = findViewById<Button>(R.id.pagamento_botao_finalizar_compra)
        botaoFinalizarCompra.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        startActivity(Intent(this, ResumoCompraActivity::class.java).putExtra("pacote", pacote ))
    }

    @RequiresApi(Build.VERSION_CODES.N)
    fun mostrarPreco(pacote: Pacote): String? {
        return MoedaUtil.moedaFormatadaBrasileira(pacote.preco)
    }
}



