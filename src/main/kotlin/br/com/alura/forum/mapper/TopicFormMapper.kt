package br.com.alura.forum.mapper

import br.com.alura.forum.dto.TopicFormNew
import br.com.alura.forum.model.Topic
import br.com.alura.forum.service.CourseService
import br.com.alura.forum.service.UserService
import org.springframework.stereotype.Component

@Component
class TopicFormMapper(
    private var courseService: CourseService,
    private var userService: UserService,
): Mapper<TopicFormNew, Topic>{
    override fun map(t: TopicFormNew): Topic {
        return Topic(

            title = t.title,
            message = t.message,
            course = courseService.findById(t.idCourse),
            author = userService.findById(t.idAuthor)
        )
    }


}
