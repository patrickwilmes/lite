package com.sevdesk.lite.customer

import com.sevdesk.lite.common.auditing.Auditable
import org.springframework.data.annotation.CreatedBy
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.time.LocalDateTime
import javax.persistence.*

@Entity
@EntityListeners(AuditingEntityListener::class)
@Table(name = "CUSTOMERS")
data class Customer(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    val id: Long? = null,
    @Column(name = "givenname")
    val givenname: String? = null,
    @Column(name = "surname")
    val surname: String? = null,
): Auditable {

    @CreatedBy
    @Column(name = "created_by", length = 512)
    override lateinit var createdBy: String

    @LastModifiedDate
    @Column(name = "last_modified_at")
    override lateinit var lastModifiedAt: LocalDateTime
}
