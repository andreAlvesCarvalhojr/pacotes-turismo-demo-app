package com.example.aluraviagens.PacoteDAO

import com.example.aluraviagens.model.Pacote


class PacoteDAO{

    fun pacoteList(): List<Pacote> {
        val list = mutableListOf<Pacote>()
        list.add(Pacote("São Paulo","sao_paulo_sp",2, 243.99))
        list.add(Pacote("Belo Horizonte","belo_horizonte_mg",3, 421.50))
        list.add(Pacote("Recife","recife_pe",4, 754.20))
        list.add(Pacote("Rio de Janeiro", "rio_de_janeiro_rj",6, 532.55))
        list.add(Pacote("Salvador","salvador_ba",5, 899.99))
        list.add(Pacote("Foz do Iguacu","foz_do_iguacu_pr",1,289.90))

       return list
    }

}


