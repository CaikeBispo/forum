package br.com.alura.forum

import br.com.alura.forum.dto.TopicFormNew
import br.com.alura.forum.dto.TopicView
import br.com.alura.forum.dto.TopicFormUpdate
import br.com.alura.forum.model.*
import br.com.alura.forum.service.TopicService
import jakarta.transaction.Transactional
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.util.UriComponentsBuilder
import java.util.*

@RestController
@RequestMapping("/topics")
class TopicController(
    private val service: TopicService
) {
    @GetMapping
    fun list(@RequestParam(required = false) courseName:String?):List<TopicView>{
        return service.list(courseName)
    }

    @GetMapping("/{id}")
    fun listById(@PathVariable id: Long): TopicView{
        return service.listById(id)
    }

    @GetMapping("/nome")
    fun caike(): String = "Caike Bispo"

    @PostMapping
    @Transactional
    fun register(
        @RequestBody @Valid form: TopicFormNew,
        uriBuilder: UriComponentsBuilder):ResponseEntity<TopicView> {

        val topicViewForm = service.register(form)
        val uri = uriBuilder.path("/topics/${topicViewForm.id}").build().toUri()
        return ResponseEntity.created(uri).body(topicViewForm)
    }

    @PutMapping
    @Transactional
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