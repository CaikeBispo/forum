package br.com.alura.forum

import br.com.alura.forum.dto.TopicFormNew
import br.com.alura.forum.dto.TopicView
import br.com.alura.forum.dto.TopicFormUpdate
import br.com.alura.forum.model.*
import br.com.alura.forum.service.TopicService
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.util.UriComponentsBuilder
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
    fun register(
        @RequestBody @Valid form: TopicFormNew,
        uriBuilder: UriComponentsBuilder):ResponseEntity<TopicView> {

        val topicViewForm = service.register(form)
        val uri = uriBuilder.path("/topics/${topicViewForm.id}").build().toUri()
        return ResponseEntity.created(uri).body(topicViewForm)
    }

    @PutMapping
    fun changeTopic(@RequestBody @Valid form: TopicFormUpdate):ResponseEntity<TopicView>{
        val topicView = service.changeTopic(form)

        return ResponseEntity.ok(topicView)
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteTopic(@PathVariable id: Long){
        service.deleteTopic(id)
    }

}