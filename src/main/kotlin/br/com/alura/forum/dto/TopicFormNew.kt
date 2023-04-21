package br.com.alura.forum.dto

//bean validation
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size

data class TopicFormNew (
    @field:NotEmpty(message = "Title can not be empty")
    @field:Size(min = 10, max = 100, message = "Title should had between 5 and 100 chars")
    val title: String,
    @field:NotEmpty(message = "Message can not be empty")
    val message: String,
    @field:NotNull
    val idCourse: Long,
    @field:NotNull
    val idAuthor: Long,
)