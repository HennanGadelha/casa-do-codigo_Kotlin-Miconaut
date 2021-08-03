package com.gadelhahennan.livro.dtos

import com.fasterxml.jackson.annotation.JsonFormat
import com.gadelhahennan.autor.Autor
import com.gadelhahennan.categoria.Categoria
import com.gadelhahennan.livro.Livro
import java.math.BigDecimal
import java.time.LocalDate
import java.util.*

data class LivroRequest(val titulo: String,
                        val resumo: String,
                        val sumario: String,
                        val preco: BigDecimal,
                        val isbn: String,
                        @JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING)
                        val dataDePublicacao: LocalDate,
                        val categoriaUuid: UUID,
                        val autorUuid: UUID
                        ) {

    fun toModel(categoria: Categoria, autor: Autor): Livro{
        return Livro(titulo, resumo, sumario, preco, isbn, dataDePublicacao, categoria, autor)
    }


}
