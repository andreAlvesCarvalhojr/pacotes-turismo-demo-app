package com.example.aluraviagens.util

import android.icu.text.NumberFormat
import android.os.Build
import androidx.annotation.RequiresApi
import java.util.*

object MoedaUtil {

    private const val portugues: String = "pt"
    private const val brasil: String = "BR"

    @RequiresApi(Build.VERSION_CODES.N)
    fun moedaFormatadaBrasileira(valor: Double): String? {
        return NumberFormat.getCurrencyInstance(Locale(portugues, brasil)).format(valor)

    }

}