package com.example.aluraviagens.ui.activity

import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.aluraviagens.PacoteDAO.PacoteDAO
import com.example.aluraviagens.R
import com.example.aluraviagens.ui.adapter.ListaPacotesAdapter

class ListaPacotesActivity : AppCompatActivity() {
    @SuppressLint("NewApi")
    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_pacotes)

        val listaDePacotes = findViewById<RecyclerView>(R.id.lista_pacotes_recyclerview)
        val listaDeItems = PacoteDAO().pacoteList()

        with(listaDePacotes) {
            layoutManager =
                LinearLayoutManager(this@ListaPacotesActivity, RecyclerView.VERTICAL, false)
            setHasFixedSize(true)
            adapter = ListaPacotesAdapter(listaDeItems, this@ListaPacotesActivity)
        }
//        listaDePacotes.setOnClickListener(this)
    }
//    override fun onClick(v: View?) {
//        val pacoteClicada = pacote
//        val intent = Intent(this@ListaPacotesActivity,R.layout.activity_resumo_compra::class.java)
//        intent.putExtra("pacote",)
//        startActivity(intent)
//    }
}