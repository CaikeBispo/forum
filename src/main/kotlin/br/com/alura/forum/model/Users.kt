package br.com.alura.forum.model

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity
data class Users (
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long?,
    var nome: String,
    val email: String,

)
