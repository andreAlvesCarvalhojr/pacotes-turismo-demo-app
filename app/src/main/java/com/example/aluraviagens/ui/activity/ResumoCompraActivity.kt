package com.example.aluraviagens.ui.activity

import android.os.Build
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.example.aluraviagens.R
import com.example.aluraviagens.model.Pacote
import com.example.aluraviagens.util.DataUtil
import com.example.aluraviagens.util.MoedaUtil.moedaFormatadaBrasileira

class ResumoCompraActivity : AppCompatActivity() {

    companion object {
        private const val EXTRA_PACOTE = "pacote"
        private var pacote: Pacote? = null
    }

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resumo_compra)

        title = "Resumo da compra"

        pacote = intent.getSerializableExtra(EXTRA_PACOTE) as Pacote

        findViewById<TextView>(R.id.resumo_compra_local_pacote).text = pacote!!.local
        findViewById<ImageView>(R.id.resumo_compra_imagem_pacote).setImageResource(resources.getIdentifier(
            ResumoPacoteActivity.pacote!!.imagem,
            "drawable",
            packageName))
        findViewById<TextView>(R.id.resumo_compra_data_viagem).text =
            mostrarData(pacote!!, DataUtil.calendar(
                pacote!!.dias))
        findViewById<TextView>(R.id.resumo_compra_preco_pacote).text = mostrarPreco(pacote!!,
            moedaFormatadaBrasileira(pacote!!.preco)).toString()
    }

    @RequiresApi(Build.VERSION_CODES.N)
    fun mostrarPreco(pacote: Pacote, preco: String?): String? {
        return moedaFormatadaBrasileira(pacote.preco)
    }

    private fun mostrarData(pacote: Pacote, periodoEmTexto: String): String {
        return DataUtil.calendar(pacote.dias)
    }
}