package br.com.alura.forum.dto

//bean validation
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size

data class NewTopicForm (
    @field:NotEmpty @field:Size(min = 10, max = 100)
    val title: String,
    @field:NotEmpty
    val message: String,
    @field:NotNull
    val idCourse: Long,
    @field:NotNull
    val idAuthor: Long,
)