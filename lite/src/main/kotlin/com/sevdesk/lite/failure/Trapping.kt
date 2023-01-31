package com.sevdesk.lite.failure

import arrow.core.Either

fun <T> trap(block: () -> T): Either<Failure, T> =
    try {
        Either.Right(block())
    } catch (e: Exception) {
        Either.Left(Failure.EncapsulatedExceptionFailure(e))
    }
