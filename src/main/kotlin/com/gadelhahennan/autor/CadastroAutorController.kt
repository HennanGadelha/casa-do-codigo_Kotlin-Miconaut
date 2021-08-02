package com.gadelhahennan.autor

import com.gadelhahennan.autor.dtos.AutorRequest
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Post
import javax.validation.Valid

@Controller("/api/v1/autores")
open class CadastroAutorController(val autorRepository: AutorRepository) {


    @Post("/cadastro")
   open  fun cadastra(@Body @Valid request: AutorRequest){

        val autor = request.toModel()
        autorRepository.save(autor)

    }

}