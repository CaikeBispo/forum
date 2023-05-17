package br.com.alura.forum.service

import br.com.alura.forum.dto.TopicFormNew
import br.com.alura.forum.dto.TopicFormUpdate
import br.com.alura.forum.dto.TopicView
import br.com.alura.forum.exception.NotFoundException
import br.com.alura.forum.mapper.TopicFormMapper
import br.com.alura.forum.mapper.TopicViewMapper
import br.com.alura.forum.repository.TopicRepository
import org.springframework.stereotype.Service
import java.util.stream.Collectors

@Service
class TopicService(
    private val repository: TopicRepository,
    private val topicViewMapper: TopicViewMapper,
    private val topicFormMapper: TopicFormMapper,
    private val notFoundMessage: String = "Topic not found"
) {
    fun list(courseName: String?): List<TopicView> {
        var topics = if(!courseName.isNullOrEmpty()){
            repository.findByCourseName(courseName)
        } else {
            repository.findAll()
        }
        return topics.stream().map {
                t -> topicViewMapper.map(t)
        }.collect(Collectors.toList())
    }

    fun listById(id: Long): TopicView{
        val topic = repository.findById(id)
            .orElseThrow{NotFoundException(notFoundMessage)}

        return topicViewMapper.map(topic)
    }

    fun register(form: TopicFormNew):TopicView {
        val topic = topicFormMapper.map(form)
        repository.save(topic)

        return topicViewMapper.map(topic)
    }

    fun changeTopic(form: TopicFormUpdate):TopicView {
        val topic = repository
            .findById(form.id)
            .orElseThrow{NotFoundException(notFoundMessage)}

        topic.title = form.title
        topic.message = form.message

        return topicViewMapper.map(topic)
    }

    fun deleteTopic(idToDelete: Long) {
        repository.deleteById(idToDelete)

    }

}