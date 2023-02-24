package br.com.alura.forum.service

import br.com.alura.forum.model.Course
import br.com.alura.forum.model.Users
import org.springframework.stereotype.Service

@Service
class UserService(
    var users: List<Users>
) {
    init {
        var user = Users(
            id = 1,
            nome = "Caike Bispo",
            email = "caike@bispo.com"
        )
        users = listOf(user)
    }

    fun findById(id: Long): Users = users.stream().filter{ user -> user.id == id}.findFirst().get()
    //    fun findById(id: Long): Course = courses.stream().filter{course -> course.id == id}.findFirst().get()


}
