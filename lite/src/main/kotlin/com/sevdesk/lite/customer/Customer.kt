package com.sevdesk.lite.customer

import javax.persistence.*

@Entity
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
)
