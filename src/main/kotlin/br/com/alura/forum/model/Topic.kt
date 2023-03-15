package br.com.alura.forum.model

import java.time.LocalDateTime

data class Topic(
    val id: Long? = null,
    val titulo: String,
    val mensagem: String,
    val datacriacao: LocalDateTime = LocalDateTime.now(),
    val curso: Course,
    val autor: Users,
    val status: StatusTopico = StatusTopico.NAO_RESPONDIDO,
    val respostas: List<Respostas> = ArrayList()
)