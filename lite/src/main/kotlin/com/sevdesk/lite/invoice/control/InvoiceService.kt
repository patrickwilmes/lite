package com.sevdesk.lite.invoice.control

import com.sevdesk.lite.invoice.entity.Invoice
import org.springframework.stereotype.Service
import java.time.OffsetDateTime

@Service
class InvoiceService(private val invoiceRepository: InvoiceRepository) {

    fun getAllInvoices(): List<Invoice> {
        return invoiceRepository.findAll().toList()
    }

    fun getInvoice(id: Long): Invoice {
        return invoiceRepository.findById(id).orElseGet { null }
    }

    fun saveInvoice(
        invoice: Invoice
    ): Invoice =
        invoice.copy(creationDate = OffsetDateTime.now()).let { invoiceWithCreationDate ->
            invoiceRepository.save(invoiceWithCreationDate)
        }
}
