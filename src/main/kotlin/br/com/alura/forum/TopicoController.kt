package br.com.alura.forum

import br.com.alura.forum.model.*
import br.com.alura.forum.service.TopicoService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
@RequestMapping("/topico")
class TopicoController(
    private val service: TopicoService
) {
    @GetMapping
    fun list():List<Topico>{
        return service.list()
    }

    @GetMapping("/{id}")
    fun listById(@PathVariable id: Long): Topico{
        return service.listById(id);
    }

}