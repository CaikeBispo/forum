package br.com.alura.forum.repository

import br.com.alura.forum.model.Users
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository: JpaRepository<Users, Long> {

}