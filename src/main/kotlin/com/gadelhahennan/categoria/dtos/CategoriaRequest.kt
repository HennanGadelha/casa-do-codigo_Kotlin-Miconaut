package com.gadelhahennan.categoria.dtos

import com.gadelhahennan.categoria.Categoria
import javax.validation.constraints.NotBlank

data class CategoriaRequest( @field:NotBlank val nome: String) {

    fun toModel(): Categoria {
        return Categoria(nome)
    }


}

