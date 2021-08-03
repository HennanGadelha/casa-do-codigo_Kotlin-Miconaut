package com.gadelhahennan.livro

import com.gadelhahennan.autor.Autor
import io.micronaut.data.annotation.Repository
import io.micronaut.data.jpa.repository.JpaRepository
import java.util.*

@Repository
interface LivroRepository : JpaRepository<Livro, Long> {

}