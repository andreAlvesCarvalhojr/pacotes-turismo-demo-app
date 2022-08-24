package com.example.aluraviagens.util

import java.text.SimpleDateFormat
import java.util.*


// Implementacão de refatoracão


internal object DataUtil{

    private const val dias_e_mes: String = "dd/MM"

    fun calendar(dias: Int): String {

        //  Calendar

        val dataIda: Calendar = Calendar.getInstance()
        val dataVolta: Calendar = Calendar.getInstance()
        dataVolta.add(Calendar.DATE, dias)
        val formatoBraisleiro = SimpleDateFormat(dias_e_mes, Locale.US)
        val dataFormatadaIda: String = formatoBraisleiro.format(dataIda.time)
        val dataFormatadaVolta: String = formatoBraisleiro.format(dataVolta.time)
        return "$dataFormatadaIda  -  $dataFormatadaVolta  de  ${
            dataVolta.get(
            Calendar.YEAR)
        }"

    }
}




