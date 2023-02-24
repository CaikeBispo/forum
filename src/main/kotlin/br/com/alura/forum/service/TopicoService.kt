package br.com.alura.forum.service

import br.com.alura.forum.dto.NovoTopicoDTO
import br.com.alura.forum.model.Topic
import org.springframework.stereotype.Service

@Service
class TopicoService(
    private var topics: List<Topic> = ArrayList(),
    private var courseService: CourseService,
    private var userService: UserService,
) {
    fun list(): List<Topic> = topics

    fun listById(id: Long): Topic = topics.stream().filter { t -> t.id == id }.findFirst().get()

    fun register(dto: NovoTopicoDTO) {
        topics = topics.plus(
            Topic(
                id = topics.size.toLong() + 1,
                titulo = dto.title,
                mensagem = dto.message,
                curso = courseService.findById(dto.idCourse),
                autor = userService.findById(dto.idAuthor)
            )
        )
    }
}