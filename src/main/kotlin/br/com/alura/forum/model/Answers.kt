package br.com.alura.forum.model

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.ManyToOne
import java.time.LocalDateTime

@Entity
data class Answers (
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long?,
    val mensagem: String,
    val dtCriation: LocalDateTime = LocalDateTime.now(),
    @ManyToOne
    val author: Users,
    @ManyToOne
    val topic: Topic,
    val solution: Boolean
)


