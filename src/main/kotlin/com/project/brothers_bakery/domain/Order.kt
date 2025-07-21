package com.project.brothers_bakery.domain

import jakarta.persistence.GenerationType
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.math.BigDecimal
import java.sql.Timestamp
import java.util.UUID

@Entity
@Table(name = "tb_orders")
data class Order(
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    val orderId: UUID?,
    val status: String?,
    val userId: UUID,
    val createdAt: Timestamp,
    val updatedAt: Timestamp,
    val totalAmount: BigDecimal
)
