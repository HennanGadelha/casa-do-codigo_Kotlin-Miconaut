package com.gadelhahennan.config.validacoes

import com.gadelhahennan.autor.Autor
import com.gadelhahennan.autor.AutorRepository
import javax.inject.Inject
import javax.inject.Singleton
import javax.persistence.EntityManager
import javax.persistence.PersistenceContext
import javax.persistence.Query
import javax.validation.Constraint
import javax.validation.ConstraintValidator
import javax.validation.ConstraintValidatorContext
import javax.validation.Payload
import kotlin.reflect.KClass

@MustBeDocumented
@Target(AnnotationTarget.FIELD)
@Retention(AnnotationRetention.RUNTIME)
@Constraint(validatedBy = [UniqueValueValidator::class])
annotation class UniqueValue(val message: String = "valor já cadastrado",
                             val groups: Array<KClass<Any>> = [],
                             val payload: Array<KClass<Payload>> = [],

)


//refatorar para validacao se tornar mais generecia

@Singleton
class UniqueValueValidator: ConstraintValidator<UniqueValue,String>{

//    private var atributo: String? = null
//    private var entidadeDominio: KClass<Any>? = null

    @Inject
    lateinit var  autorRepository: AutorRepository

//    @PersistenceContext
//    private val em: EntityManager? = null


//    override fun initialize(params: UniqueValue?) {
//
//        atributo = params!!.fieldName
//        entidadeDominio = params!!.entidadeDominio
//
//    }

    override fun isValid(value: String?, context: ConstraintValidatorContext?): Boolean {

//        val query: Query = em!!.createQuery("SELECT 1 FROM ${entidadeDominio!!.simpleName} + WHERE + $atributo =:value")
//
//        query.setParameter("value", value)
//
//        val resultQuery: MutableList<Any> = query.resultList as MutableList<Any>
//
//        return resultQuery.isEmpty()


        val autorComEmailJaCadsatrado = autorRepository.findByEmail(value)

        return autorComEmailJaCadsatrado.isEmpty


    }


}