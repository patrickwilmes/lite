package com.sevdesk.lite.invoice.adapter.persistence

import com.sevdesk.lite.invoice.Invoice
import org.springframework.data.repository.CrudRepository

interface InvoiceRepository : CrudRepository<Invoice, Long>
