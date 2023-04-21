package br.com.alura.forum.service

import br.com.alura.forum.dto.TopicFormNew
import br.com.alura.forum.dto.TopicFormUpdate
import br.com.alura.forum.dto.TopicView
import br.com.alura.forum.exception.NotFoundException
import br.com.alura.forum.mapper.TopicFormMapper
import br.com.alura.forum.mapper.TopicViewMapper
import br.com.alura.forum.model.Topic
import org.springframework.stereotype.Service
import java.util.stream.Collectors

@Service
class TopicService(
    private var topics: List<Topic> = ArrayList(),
    private val topicViewMapper: TopicViewMapper,
    private val topicFormMapper: TopicFormMapper,
    private val notFoundMessage: String = "Topic not found"
) {
    fun list(): List<TopicView> {
        return topics.stream().map {
                t -> topicViewMapper.map(t)
        }.collect(Collectors.toList())
    }

    fun listById(id: Long): TopicView{
        val topic = topics.stream().filter { t -> t.id == id }.findFirst().orElseThrow{NotFoundException(notFoundMessage)}

        return topicViewMapper.map(topic)
    }

    fun register(form: TopicFormNew):TopicView {
        val topic = topicFormMapper.map(form)
        topic.id = topics.size.toLong() + 1
        topics = topics.plus(topic)

        return topicViewMapper.map(topic)
    }

    fun changeTopic(form: TopicFormUpdate):TopicView {
        val topic = topics.stream().filter {t ->
            t.id == form.id
        }.findFirst().orElseThrow{NotFoundException(notFoundMessage)}

        val changedTopic = Topic(
            id = form.id,
            title = form.title,
            message = form.message,
            course = topic.course,
            author = topic.author,
            answers = topic.answers

        )

        topics = topics.minus(topic).plus(changedTopic)

        return topicViewMapper.map(changedTopic)
    }

    fun deleteTopic(idToDelete: Long) {
        topics = topics.minus(
            topics.stream().filter{ t ->
                t.id == idToDelete
            }.findFirst().orElseThrow{NotFoundException(notFoundMessage)}
        )

    }

}