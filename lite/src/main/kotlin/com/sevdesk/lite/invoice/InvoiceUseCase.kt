package com.sevdesk.lite.invoice

import arrow.core.Either
import com.sevdesk.lite.failure.Failure

interface InvoiceUseCase {
    fun getAllInvoices(): Either<Failure, List<Invoice>>

    suspend fun getInvoice(id: Long): Either<Failure, Invoice>

    fun saveInvoice(invoice: Invoice): Either<Failure, Invoice>

    fun deleteInvoice(id: Long): Either<Failure, Unit>
}
