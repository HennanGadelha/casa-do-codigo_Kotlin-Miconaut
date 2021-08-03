package com.gadelhahennan.livro

import com.gadelhahennan.autor.Autor
import com.gadelhahennan.categoria.Categoria
import java.math.BigDecimal
import java.time.LocalDate
import java.util.*
import javax.persistence.*

@Entity
class Livro(
    val titulo: String,
    val resumo: String,
    val sumario: String,
    val preco: BigDecimal,
    val isbn: String,
    val dataDePublicacao: LocalDate,
    @OneToOne
    val categoria: Categoria,
    @OneToOne
    val autor: Autor
) {

    @Id
    @GeneratedValue
    val id: Long? =null;
    val livroUuid: UUID = UUID.randomUUID()
}