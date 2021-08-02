package com.gadelhahennan.categoria

import java.util.*
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
class Categoria(val nome: String) {

    @Id
    @GeneratedValue
    val id: Long? =null;
    val categoriaUuid: UUID = UUID.randomUUID()
}