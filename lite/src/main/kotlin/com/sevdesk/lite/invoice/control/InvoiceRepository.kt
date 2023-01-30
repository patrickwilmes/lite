package com.sevdesk.lite.invoice.control

import com.sevdesk.lite.invoice.entity.Invoice
import org.springframework.data.repository.CrudRepository

interface InvoiceRepository : CrudRepository<Invoice, Long>
