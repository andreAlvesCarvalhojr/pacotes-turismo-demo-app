package com.example.aluraviagens.ui.adapter

import android.content.Context
import android.content.Intent
import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import com.example.aluraviagens.R
import com.example.aluraviagens.model.Pacote
import com.example.aluraviagens.ui.activity.ResumoPacoteActivity
import com.example.aluraviagens.util.DiasUtil
import com.example.aluraviagens.util.MoedaUtil

class ListaPacotesAdapter(
    private val pacotes: List<Pacote>,
    private val context: Context ) :
    RecyclerView.Adapter<ListaPacotesAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_pacote, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount() = pacotes.size

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {

        val local: TextView
        val image: ImageView
        val dias: TextView
        val preco: TextView
        private val v: androidx.constraintlayout.widget.ConstraintLayout

        init {
            local = itemView.findViewById(R.id.item_pacote_local)
            image = itemView.findViewById(R.id.item_pacote_imagem)
            dias = itemView.findViewById(R.id.item_pacote_dias)
            preco = itemView.findViewById(R.id.item_pacote_dias_preco)
            v = itemView.findViewById(R.id.wrap_item)
            v.setOnClickListener(this)
        }

        fun bindView(item: Pacote){
        }

        override fun onClick(v: View?) {
            context.startActivity(Intent(context,ResumoPacoteActivity::class.java).putExtra("pacote", pacotes[position]))
//            val intent = Intent(context,ResumoPacoteActivity::class.java)
//            intent.putExtra("pacote",pacotes[position])
//            context.startActivity(intent)

        }
    }

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.local.text = pacotes[position].local
        holder.image.setImageResource(context.resources.getIdentifier(pacotes[position].imagem,
            "drawable",
            context.packageName))
        holder.dias.text = DiasUtil.diasFormatadaEmTexto(pacotes[position].dias)
        holder.preco.text = MoedaUtil.moedaFormatadaBrasileira(pacotes[position].preco)

        holder.bindView(pacotes[position])
    }
}





