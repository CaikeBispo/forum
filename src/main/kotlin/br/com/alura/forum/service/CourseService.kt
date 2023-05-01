package br.com.alura.forum.service

import br.com.alura.forum.model.Course
import br.com.alura.forum.repository.CourseRepository
import org.springframework.stereotype.Service
import java.util.*
@Service
class CourseService(
    private val repository: CourseRepository
) {

    fun findById(id: Long): Course{
        return repository.getOne(id)
    }


}
