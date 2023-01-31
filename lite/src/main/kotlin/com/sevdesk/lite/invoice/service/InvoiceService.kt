package com.sevdesk.lite.invoice.service

import com.sevdesk.lite.invoice.Invoice
import com.sevdesk.lite.invoice.InvoiceUseCase
import com.sevdesk.lite.invoice.adapter.persistence.InvoiceRepository
import org.springframework.stereotype.Service
import java.time.OffsetDateTime

@Service
class InvoiceService(private val invoiceRepository: InvoiceRepository) : InvoiceUseCase {

    override fun getAllInvoices(): List<Invoice> {
        return invoiceRepository.findAll().toList()
    }

    override fun getInvoice(id: Long): Invoice {
        return invoiceRepository.findById(id).orElseGet { null }
    }

    override fun saveInvoice(
        invoice: Invoice
    ): Invoice =
        invoice.copy(creationDate = OffsetDateTime.now()).let { invoiceWithCreationDate ->
            invoiceRepository.save(invoiceWithCreationDate)
        }

    override fun deleteInvoice(id: Long) {
        invoiceRepository.deleteById(id)
    }
}
