package br.com.alura.forum.model

import java.time.LocalDateTime

data class Topic(
    var id: Long? = null,
    val title: String,
    val message: String,
    val dateCriation: LocalDateTime = LocalDateTime.now(),
    val course: Course,
    val author: Users,
    val status: StatusTopico = StatusTopico.NAO_RESPONDIDO,
    val answers: List<Respostas> = ArrayList()
)