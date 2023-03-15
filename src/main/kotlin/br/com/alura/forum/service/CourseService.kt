package br.com.alura.forum.service

import br.com.alura.forum.model.Course
import org.springframework.stereotype.Service
import java.util.*
@Service
class CourseService(
    private var courses: List<Course>
) {
    init {
        var course = Course(
            id = 1,
            nome = "Kotlin",
            categoria = "Programação"
        )

        courses = Arrays.asList(course)
    }

    fun findById(id: Long): Course = courses.stream().filter{course -> course.id == id}.findFirst().get()


}
