package br.com.alura.forum.dto

data class NovoTopicoDTO (
    val title: String,
    val message: String,
    val idCourse: Long,
    val idAuthor: Long,
)