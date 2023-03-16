package br.com.alura.forum.dto

import br.com.alura.forum.model.StatusTopico
import java.time.LocalDateTime

data class TopicView (
    val id: Long?,
    val title: String,
    val message: String,
    val status: StatusTopico,
    val dateCriation: LocalDateTime
)