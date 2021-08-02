package com.gadelhahennan.categoria

import com.gadelhahennan.categoria.dtos.CategoriaRequest
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Post
import java.util.*
import javax.validation.Valid

@Controller("/api/v1/categorias")
open class CadastroCategoriaController(val categoriaRepository: CategoriaRepository) {

    @Post("/cadastro")
    open fun cadastro(@Body @Valid request: CategoriaRequest) : HttpResponse<Any>{

        val categoria = request.toModel()

        categoriaRepository.save(categoria)

        return HttpResponse.created(location(categoria.categoriaUuid))

    }

    private fun location(categoriaUUID: UUID) = HttpResponse.uri("/api/v1/categorias/$categoriaUUID")
}