package com.example.aluraviagens.ui.activity

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.example.aluraviagens.R
import com.example.aluraviagens.model.Pacote
import com.example.aluraviagens.util.DataUtil
import com.example.aluraviagens.util.DiasUtil
import com.example.aluraviagens.util.MoedaUtil

class ResumoPacoteActivity : AppCompatActivity(), View.OnClickListener {
    @RequiresApi(Build.VERSION_CODES.N)

    companion object {
        private const val EXTRA_PACOTE = "pacote"
        var pacote: Pacote? = null
    }

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resumo_pacote)

        title = "Resumo Pacote"

        pacote = intent.getSerializableExtra(EXTRA_PACOTE) as Pacote
        findViewById<TextView>(R.id.resumo_pacote_local).text = pacote!!.local
        findViewById<ImageView>(R.id.resumo_pacote_imagem).setImageResource(resources.getIdentifier(
            pacote!!.imagem,
            "drawable",
            packageName))
        findViewById<TextView>(R.id.resumo_pacote_dias).text =
            mostraDias(pacote!!, DiasUtil.diasFormatadaEmTexto(pacote!!.dias))
        findViewById<TextView>(R.id.resumo_pacote_preco).text =
            mostraPreco(pacote!!, MoedaUtil.moedaFormatadaBrasileira(pacote!!.preco)).toString()
        findViewById<TextView>(R.id.resumo_pacote_data).text =
            mostrarData(pacote!!, DataUtil.calendar(pacote!!.dias))

        val botaoRealizaPagamento = findViewById<Button>(R.id.resumo_pacote_botao_realiza_pagamento)
        botaoRealizaPagamento.setOnClickListener(this)
    }


    @RequiresApi(Build.VERSION_CODES.N)
    override fun onClick(v: View?) {
        startActivity(Intent(this, PagamentoActivity::class.java).putExtra("pacote", pacote))
    }

    private fun mostrarData(pacote: Pacote, dataFormatadaDaViagem: String): String {
        return DataUtil.calendar(pacote.dias)
    }

    @RequiresApi(Build.VERSION_CODES.N)
    private fun mostraPreco(pacote: Pacote, moedaBrasileira: String?): String? {
        return MoedaUtil.moedaFormatadaBrasileira(pacote.preco)
    }

    private fun mostraDias(pacote: Pacote, diasEmTexto: String): String {
        return DiasUtil.diasFormatadaEmTexto(pacote.dias)
    }


}



