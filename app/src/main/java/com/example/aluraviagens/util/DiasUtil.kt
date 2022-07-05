package com.example.aluraviagens.util

object DiasUtil {

    private const val plural: String = " dias"
    private const val singular: String = " dia"

    fun diasFormatadaEmTexto(quantidadeDeDias: Int): String {
        val nameDay: String
        if (quantidadeDeDias > 1) {
            nameDay = plural
        } else {
            nameDay = singular
        }
        return nameDay
    }
}