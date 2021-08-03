package com.gadelhahennan.autor

import io.micronaut.data.annotation.Repository
import io.micronaut.data.jpa.repository.JpaRepository
import java.util.*

@Repository
interface AutorRepository : JpaRepository<Autor, Long> {
     fun findByEmail(value: String?): Optional<Autor>
     fun findByAutorUuid(autorUuid: UUID): Optional<Autor>
}