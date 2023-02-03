package com.sevdesk.lite.failure

import org.slf4j.Logger
import org.springframework.http.ResponseEntity
import kotlin.reflect.KClass

sealed class Failure(
    val message: String,
) {
    class ValidationFailure(message: String) : Failure(message)

    data class NotFoundFailure(val id: Long, private val domainType: KClass<*>) :
        Failure("No element with id $id for type ${domainType.simpleName} found!")

    data class EncapsulatedExceptionFailure(val exception: Exception) :
        Failure(exception.localizedMessage)
}

fun <T> transformToResponseEntity(failure: Failure, logger: Logger): ResponseEntity<T> =
    when (failure) {
        is Failure.EncapsulatedExceptionFailure -> {
            logger.error(failure.message)
            ResponseEntity.internalServerError().build()
        }

        is Failure.NotFoundFailure -> {
            logger.warn(failure.message)
            ResponseEntity.notFound().build()
        }

        is Failure.ValidationFailure -> {
            logger.warn(failure.message)
            ResponseEntity.badRequest().build()
        }
    }
