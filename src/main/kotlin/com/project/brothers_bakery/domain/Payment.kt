package com.project.brothers_bakery.domain

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.math.BigDecimal
import java.sql.Timestamp
import java.util.UUID

@Entity
@Table(name = "tb_payments")
data class Payment(
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    val paymentId: UUID?,
    val orderId: UUID,
    val paymentMethod: String,
    val paymentStatus: String,
    val paidAmount: BigDecimal,
    val paymentDate: Timestamp,
)
