package com.sevdesk.lite.invoice.service

import arrow.core.Either
import arrow.core.computations.either
import arrow.core.computations.ensureNotNull
import com.sevdesk.lite.failure.Failure
import com.sevdesk.lite.failure.trap
import com.sevdesk.lite.invoice.Invoice
import com.sevdesk.lite.invoice.InvoiceUseCase
import com.sevdesk.lite.invoice.adapter.persistence.InvoiceRepository
import org.springframework.security.access.annotation.Secured
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.stereotype.Service
import java.time.OffsetDateTime
import javax.annotation.security.RolesAllowed

@Service
class InvoiceService(private val invoiceRepository: InvoiceRepository) : InvoiceUseCase {

    @PreAuthorize("hasRole('USER') or hasRole('VIEWER')")
    override fun getAllInvoices(): Either<Failure, List<Invoice>> =
        trap {
            invoiceRepository.findAll().toList()
        }

    @PreAuthorize("hasRole('USER') or hasRole('VIEWER')")
    override suspend fun getInvoice(id: Long): Either<Failure, Invoice> =
        either {
            val possibleInvoice = trap {
                invoiceRepository.findById(id).orElseGet { null }
            }.bind()
            ensureNotNull(possibleInvoice) { Failure.NotFoundFailure(id, Invoice::class) }
        }

    @PreAuthorize("hasRole('USER')")
    override fun saveInvoice(
        invoice: Invoice
    ): Either<Failure, Invoice> =
        trap {
            invoice.copy(creationDate = OffsetDateTime.now()).let { invoiceWithCreationDate ->
                invoiceRepository.save(invoiceWithCreationDate)
            }
        }

    @PreAuthorize("hasRole('USER')")
    override fun deleteInvoice(id: Long): Either<Failure, Unit> =
        trap {
            invoiceRepository.deleteById(id)
        }
}
