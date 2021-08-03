package com.gadelhahennan.livro

import com.gadelhahennan.autor.AutorRepository
import com.gadelhahennan.categoria.CategoriaRepository
import com.gadelhahennan.livro.dtos.LivroRequest
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Post
import java.util.*

@Controller("/api/v1/livros")
class CadastroLivroController(
    val livroRepository: LivroRepository,
    val categoriaRepository: CategoriaRepository,
    val autorRepository: AutorRepository
) {

    @Post("/cadastro")
    fun cadastro(@Body request: LivroRequest) : HttpResponse<Any>{

        val categoria = categoriaRepository.findByCategoriaUuid(request.categoriaUuid)

        val autor = autorRepository.findByAutorUuid(request.autorUuid)
       //tratar exceptions not found de categorias e autores

        val livro = request.toModel(categoria.get(), autor.get())

        livroRepository.save(livro)

        return HttpResponse.created(location(livro.livroUuid))

    }

    private fun location(livroUuid: UUID) = HttpResponse.uri("/api/v1/categorias/$livroUuid")

}