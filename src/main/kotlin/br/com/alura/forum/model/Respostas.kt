package br.com.alura.forum.model

import java.net.IDN
import java.time.LocalDateTime

data class Respostas (
    var id: Long?,
    val mensagem: String,
    val dataCriacao: LocalDateTime = LocalDateTime.now(),
    val autor: Usuario,
    val topico: String,
    val solucao: Boolean
)


