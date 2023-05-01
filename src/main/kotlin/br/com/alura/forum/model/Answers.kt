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
    val dataCriacao: LocalDateTime = LocalDateTime.now(),
    @ManyToOne
    val autor: Users,
    @ManyToOne
    val topico: String,
    val solucao: Boolean
)


