package com.example.aluraviagens.util

import android.content.Context
import android.content.res.Resources

object ResourceUtil {

    private const val drawable: String = "drawable"

    fun imageDrawable(context: Context, drawableEmTexto: String){
        val resource: Resources = context.resources
        val idDoDrawable: Int = resource.getIdentifier(drawableEmTexto, drawable,context.packageName)
        resource.getDrawable(idDoDrawable)
    }
}