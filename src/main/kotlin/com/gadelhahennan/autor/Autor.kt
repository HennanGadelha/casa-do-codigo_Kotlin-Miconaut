package com.gadelhahennan.autor

import java.time.LocalDateTime
import java.util.*
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
class Autor(
    val nome: String,
    val email: String,
    val descricao: String
) {

    @Id
    @GeneratedValue
    val id: Long? =null;
    val autorId: UUID = UUID.randomUUID()
    val criadoEm: LocalDateTime = LocalDateTime.now()

}