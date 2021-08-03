package com.gadelhahennan.autor

import com.gadelhahennan.autor.dtos.AutorRequest
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Post
import java.util.*
import javax.validation.Valid

@Controller("/api/v1/autores")
open class CadastroAutorController(val autorRepository: AutorRepository) {


    @Post("/cadastro")
   open  fun cadastra(@Body @Valid request: AutorRequest) : HttpResponse<Any>{

        val autor = request.toModel()
        autorRepository.save(autor)

        return HttpResponse.created(location(autor.autorUuid))

    }

    private fun location(autorUUID: UUID) = HttpResponse.uri("/api/v1/autores/$autorUUID")

}