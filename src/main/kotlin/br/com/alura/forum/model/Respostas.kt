package br.com.alura.forum.model

import java.time.LocalDateTime

data class Respostas (
    var id: Long?,
    val mensagem: String,
    val dataCriacao: LocalDateTime = LocalDateTime.now(),
    val autor: Users,
    val topico: String,
    val solucao: Boolean
)


