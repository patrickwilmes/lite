package com.sevdesk.lite.invoice

import com.sevdesk.lite.customer.Customer
import java.math.BigDecimal
import java.time.LocalDate
import java.time.OffsetDateTime
import javax.persistence.*

@Entity
@Table(name = "INVOICES")
data class Invoice(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    val id: Long? = null,
    @Column(name = "status", length = 50)
    val status: String? = null,
    @Column(name = "creation_date")
    val creationDate: OffsetDateTime? = null,
    @Column(name = "due_date")
    val dueDate: LocalDate? = null,
    @Column(name = "invoice_number")
    val invoiceNumber: String? = null,
    @Column(name = "quantity")
    val quantity: BigDecimal? = null,
    @Column(name = "price_net")
    val priceNet: BigDecimal? = null,
    @Column(name = "price_gross")
    val priceGross: BigDecimal? = null,
    @ManyToOne(cascade = [CascadeType.ALL])
    val customer: Customer? = null,
)
