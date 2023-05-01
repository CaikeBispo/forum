package br.com.alura.forum.service

import br.com.alura.forum.model.Course
import br.com.alura.forum.model.Users
import br.com.alura.forum.repository.UserRepository
import org.springframework.stereotype.Service

@Service
class UserService(
    private val repository: UserRepository
) {

    fun findById(id: Long): Users {
      return repository.getOne(id);
    }


}
