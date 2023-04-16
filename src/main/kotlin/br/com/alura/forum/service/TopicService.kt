package br.com.alura.forum.service

import br.com.alura.forum.dto.TopicFormNew
import br.com.alura.forum.dto.TopicFormUpdate
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

    fun register(form: TopicFormNew) {
        val topic = topicFormMapper.map(form)
        topic.id = topics.size.toLong() + 1
        topics = topics.plus(topic)
    }

    fun changeTopic(form: TopicFormUpdate):Boolean {
        var topic = topics.stream().filter {t ->
            t.id == form.id
        }.findFirst().get()

        topics = topics.minus(topic).plus(Topic(
            id = form.id,
            title = form.title,
            message = form.message,
            course = topic.course,
            author = topic.author,
            answers = topic.answers

        ))

        return true;
    }

    fun deleteTopic(idToDelete: Long) {
        topics = topics.minus(
            topics.stream().filter{ t ->
                t.id == idToDelete
            }.findFirst().get()
        )

    }

}