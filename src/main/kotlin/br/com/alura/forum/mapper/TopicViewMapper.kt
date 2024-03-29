package br.com.alura.forum.mapper

import br.com.alura.forum.dto.TopicView
import br.com.alura.forum.model.Topic
import org.springframework.stereotype.Component

@Component
class TopicViewMapper: Mapper<Topic, TopicView>{

    override fun map(t: Topic): TopicView = TopicView(
        id = t.id,
        title = t.title,
        message = t.message,
        status = t.status,
        dateCriation = t.dtCriation
    )

}