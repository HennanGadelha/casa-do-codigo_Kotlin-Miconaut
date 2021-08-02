package com.gadelhahennan.autor.dtos

import com.gadelhahennan.autor.Autor
import javax.validation.constraints.Email
import javax.validation.constraints.NotBlank

data class AutorRequest(
    @field:NotBlank val nome: String,
    @field:NotBlank @field:Email val email: String,
    @field:NotBlank val descricao: String
){

    fun toModel() : Autor {
        return Autor(nome, email, descricao)
    }


}
