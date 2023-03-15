package br.com.alura.forum.model

data class Course (
    var id: Long?,
    var nome: String,
    var categoria: String,
    private var status: Boolean = true
)