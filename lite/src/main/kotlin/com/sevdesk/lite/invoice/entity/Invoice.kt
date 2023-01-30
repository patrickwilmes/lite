package com.sevdesk.lite.invoice.entity

import java.math.BigDecimal
import java.time.LocalDate
import java.time.OffsetDateTime
import javax.persistence.CascadeType
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.ManyToOne
import javax.persistence.Table

@Entity
@Table(name = "INVOICES")
class Invoice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    var id: Long? = null

    @Column(name = "status", length = 50)
    var status: String? = null

    @Column(name = "creation_date")
    var creationDate: OffsetDateTime? = null

    @Column(name = "due_date")
    var dueDate: LocalDate? = null

    @Column(name = "invoice_number")
    var invoiceNumber: String? = null

    @Column(name = "quantity")
    var quantity: BigDecimal? = null

    @Column(name = "price_net")
    var priceNet: BigDecimal? = null

    @Column(name = "price_gross")
    var priceGross: BigDecimal? = null

    @ManyToOne(cascade = [CascadeType.ALL])
    var customer: Customer? = null
}
