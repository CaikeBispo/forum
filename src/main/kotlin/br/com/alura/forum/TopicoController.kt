package br.com.alura.forum

import br.com.alura.forum.dto.NovoTopicoDTO
import br.com.alura.forum.model.*
import br.com.alura.forum.service.TopicoService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
@RequestMapping("/topics")
class TopicoController(
    private val service: TopicoService
) {
    @GetMapping
    fun list():List<Topic>{
        return service.list()
    }

    @GetMapping("/{id}")
    fun listById(@PathVariable id: Long): Topic{
        return service.listById(id);
    }

    @PostMapping
    fun register(@RequestBody dto: NovoTopicoDTO) {
        service.register(dto)
    }

}