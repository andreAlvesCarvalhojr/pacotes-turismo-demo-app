package com.example.aluraviagens.model

import java.io.Serializable

data class Pacote(
    val local: String,
    val imagem: String,
    val dias: Int,
    val preco: Double
) : Serializable
