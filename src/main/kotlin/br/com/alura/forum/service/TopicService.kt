package br.com.alura.forum.service

import br.com.alura.forum.dto.NewTopicForm
import br.com.alura.forum.dto.TopicView
import br.com.alura.forum.mapper.TopicFormMapper
import br.com.alura.forum.mapper.TopicViewMapper
import br.com.alura.forum.model.Topic
import org.springframework.stereotype.Service
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
        val updatedTopic = topicFormMapper.map(form)
        updatedTopic.id = topics.size.toLong() + 1
        topics = topics.plus(updatedTopic)
    }
}