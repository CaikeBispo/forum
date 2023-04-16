package br.com.alura.forum

import br.com.alura.forum.dto.TopicFormNew
import br.com.alura.forum.dto.TopicView
import br.com.alura.forum.dto.TopicFormUpdate
import br.com.alura.forum.model.*
import br.com.alura.forum.service.TopicService
import jakarta.validation.Valid
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
@RequestMapping("/topics")
class TopicController(
    private val service: TopicService
) {
    @GetMapping
    fun list():List<TopicView>{
        return service.list()
    }

    @GetMapping("/{id}")
    fun listById(@PathVariable id: Long): TopicView{
        return service.listById(id)
    }

    @GetMapping("/nome")
    fun caike(): String = "Caike Bispo"

    @PostMapping
    fun register(@RequestBody @Valid form: TopicFormNew) {
        service.register(form)
    }

    @PutMapping
    fun changeTopic(@RequestBody @Valid form: TopicFormUpdate){
        service.changeTopic(form)
    }

}