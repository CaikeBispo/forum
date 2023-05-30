package br.com.alura.forum

import br.com.alura.forum.dto.TopicFormNew
import br.com.alura.forum.dto.TopicView
import br.com.alura.forum.dto.TopicFormUpdate
import br.com.alura.forum.model.*
import br.com.alura.forum.service.TopicService
import jakarta.transaction.Transactional
import jakarta.validation.Valid
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.web.PageableDefault
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
    @Cacheable("topicos")
    fun list(
        @RequestParam(required = false) courseName:String?,
        @PageableDefault(size = 3) pagination: Pageable
    ):Page<TopicView>{
        return service.list(courseName, pagination)
    }

    @GetMapping("/{id}")
    fun listById(@PathVariable id: Long): TopicView{
        return service.listById(id)
    }

    @GetMapping("/nome")
    fun caike(): String = "Caike Bispo"

    @PostMapping
    @Transactional
    @CacheEvict(value = ["topicos"], allEntries = true)
    fun register(
        @RequestBody @Valid form: TopicFormNew,
        uriBuilder: UriComponentsBuilder):ResponseEntity<TopicView> {

        val topicViewForm = service.register(form)
        val uri = uriBuilder.path("/topics/${topicViewForm.id}").build().toUri()
        return ResponseEntity.created(uri).body(topicViewForm)
    }

    @PutMapping
    @Transactional
    @CacheEvict(value = ["topicos"], allEntries = true)
    fun changeTopic(@RequestBody @Valid form: TopicFormUpdate):ResponseEntity<TopicView>{
        val topicView = service.changeTopic(form)

        return ResponseEntity.ok(topicView)
    }

    
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @CacheEvict(value = ["topicos"], allEntries = true)
    fun deleteTopic(@PathVariable id: Long){
        service.deleteTopic(id)
    }

}
