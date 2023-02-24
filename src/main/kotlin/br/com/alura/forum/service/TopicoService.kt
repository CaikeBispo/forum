package br.com.alura.forum.service

import br.com.alura.forum.model.Curso
import br.com.alura.forum.model.StatusTopico
import br.com.alura.forum.model.Topico
import br.com.alura.forum.model.Usuario
import org.springframework.stereotype.Service
import java.time.LocalDateTime

@Service
class TopicoService(
    private var topicos: List<Topico>
) {
    init {
        val topico = Topico(
            id = 1,
            titulo = "Primeira dúvida sobre KT",
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

        val topico2 = Topico(
            id = 2,
            titulo = "Segunda dúvida sobre KT",
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

        val topico3 = Topico(
            id = 3,
            titulo = "Terceira dúvida sobre KT",
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

        topicos = listOf(topico, topico2, topico3)
    }
    fun list(): List<Topico> = topicos

    fun listById(id: Long): Topico = topicos.stream().filter { t -> t.id == id }.findFirst().get()
}