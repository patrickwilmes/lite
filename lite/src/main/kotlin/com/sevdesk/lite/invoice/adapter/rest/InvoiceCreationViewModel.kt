package com.sevdesk.lite.invoice.adapter.rest

import com.sevdesk.lite.customer.Customer
import com.sevdesk.lite.invoice.Invoice
import java.math.BigDecimal
import java.time.LocalDate

data class InvoiceCreationViewModel(
    val dueDate: LocalDate,
    val invoiceNumber: String,
    val quantity: BigDecimal,
    val priceNet: BigDecimal,
    val customer: Customer,
)

fun InvoiceCreationViewModel.toDomain() =
    Invoice(
        dueDate = dueDate,
        invoiceNumber = invoiceNumber,
        quantity = quantity,
        priceNet = priceNet,
        customer = customer,
    )
