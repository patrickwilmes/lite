package com.sevdesk.lite.invoice

interface InvoiceUseCase {
    fun getAllInvoices(): List<Invoice>

    fun getInvoice(id: Long): Invoice

    fun saveInvoice(invoice: Invoice): Invoice

    fun deleteInvoice(id: Long)
}
