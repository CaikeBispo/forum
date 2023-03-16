package br.com.alura.forum.service

import br.com.alura.forum.dto.NewTopicForm
import br.com.alura.forum.dto.TopicView
import br.com.alura.forum.model.Topic
import org.springframework.stereotype.Service
import java.util.stream.Collectors

@Service
class TopicService(
    private var topics: List<Topic> = ArrayList(),
    private var courseService: CourseService,
    private var userService: UserService,
) {
    fun list(): List<TopicView> {
        return topics.stream().map { t -> TopicView(
            id = t.id,
            title = t.title,
            message = t.message,
            status = t.status,
            dateCriation = t.dateCriation
        )}.collect(Collectors.toList())
    }

    fun listById(id: Long): TopicView{
        val topic = topics.stream().filter { t -> t.id == id }.findFirst().get()

        return TopicView(
            id = topic.id,
            title = topic.title,
            message = topic.message,
            status = topic.status,
            dateCriation = topic.dateCriation
        )
    }

    fun register(dto: NewTopicForm) {
        topics = topics.plus(
            Topic(
                id = topics.size.toLong() + 1,
                title = dto.title,
                message = dto.message,
                course = courseService.findById(dto.idCourse),
                author = userService.findById(dto.idAuthor)
            )
        )
    }
}