package com.sevdesk.lite.invoice

import com.sevdesk.lite.common.auditing.Auditable
import com.sevdesk.lite.customer.Customer
import org.springframework.data.annotation.CreatedBy
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.math.BigDecimal
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.OffsetDateTime
import javax.persistence.*

@Entity
@EntityListeners(AuditingEntityListener::class)
@Table(name = "INVOICES")
data class Invoice(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    val id: Long? = null,
    @Column(name = "status", length = 50)
    val status: InvoiceStatus = InvoiceStatus.Open,
    @Column(name = "creation_date")
    val creationDate: OffsetDateTime? = null,
    @Column(name = "due_date")
    val dueDate: LocalDate,
    @Column(name = "invoice_number")
    val invoiceNumber: String,
    @Column(name = "quantity")
    val quantity: BigDecimal,
    @Column(name = "price_net")
    val priceNet: BigDecimal,
    @ManyToOne(cascade = [CascadeType.ALL])
    val customer: Customer,
) : Auditable {
    @get:Column(name = "price_gross")
    val priceGross = priceNet.plus(priceNet.times(BigDecimal(0.17)))

    @CreatedBy
    @Column(name = "created_by", length = 512)
    override lateinit var createdBy: String

    @LastModifiedDate
    @Column(name = "last_modified_at")
    override lateinit var lastModifiedAt: LocalDateTime
}
