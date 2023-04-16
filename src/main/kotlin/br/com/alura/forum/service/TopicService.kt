package br.com.alura.forum.service

import br.com.alura.forum.dto.NewTopicForm
import br.com.alura.forum.dto.TopicView
import br.com.alura.forum.mapper.TopicFormMapper
import br.com.alura.forum.mapper.TopicViewMapper
import br.com.alura.forum.model.Topic
import jakarta.validation.Valid
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.RequestBody
import java.util.stream.Collectors

@Service
class TopicService(
    private var topics: List<Topic> = ArrayList(),
    private val topicViewMapper: TopicViewMapper,
    private val topicFormMapper: TopicFormMapper
) {
    fun list(): List<TopicView> {
        return topics.stream().map {
                t -> topicViewMapper.map(t)
        }.collect(Collectors.toList())
    }

    fun listById(id: Long): TopicView{
        val topic = topics.stream().filter { t -> t.id == id }.findFirst().get()

        return topicViewMapper.map(topic)
    }

    fun register(form: NewTopicForm) {
        val topic = topicFormMapper.map(form)
        topic.id = topics.size.toLong() + 1
        topics = topics.plus(topic)
    }
}