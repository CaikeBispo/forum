package br.com.alura.forum

import br.com.alura.forum.model.*
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.time.LocalDateTime
import java.util.*

@RestController
@RequestMapping("/topico")
class TopicoController {
    @GetMapping
    fun listar():List<Topico>{

        var topico = Topico(
            id = 1,
            titulo = "Qualquer dúvida sobre SPRING",
            mensagem = "Gostaria de qualquer resposta para minha pergunta",
            datacriacao = LocalDateTime.now(),
            curso = Curso(
                1,
                "Kotlin",
                "Programação"
            ),
            autor = Usuario(
                1,
                "Caike Bispo",
                "aa@aa.com"
            ),
            status = StatusTopico.NAO_RESPONDIDO,

            )

        return listOf(topico, topico, topico)
    }
}