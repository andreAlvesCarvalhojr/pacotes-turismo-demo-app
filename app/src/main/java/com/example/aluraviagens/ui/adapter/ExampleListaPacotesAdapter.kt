package com.example.aluraviagens.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.example.aluraviagens.R
import com.example.aluraviagens.model.Pacote


// Teste BaseAdapter



open class ExampleListaPacotesAdapter(val pacotes: List<Pacote>, val  contextParameter: Context) :
    BaseAdapter() {

    private val inflater: LayoutInflater
            = contextParameter.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

       override fun getCount(): Int {
        return pacotes.size
    }

    override fun getItem(position: Int): Pacote {
        return pacotes[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View? =
        parent.apply {
            inflate(R.layout.item_pacote, parent)
        }

    private fun inflate(itemPacote: Int, parent: ViewGroup): View {
        return inflater.inflate(itemPacote, parent, false)

    }

}


