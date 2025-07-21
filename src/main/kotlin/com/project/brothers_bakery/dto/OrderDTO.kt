package com.project.brothers_bakery.dto

import com.project.brothers_bakery.domain.Order
import java.math.BigDecimal
import java.sql.Timestamp
import java.util.UUID

data class OrderDTO(
    val id: UUID?,
    val status: String?,
    val userId: UUID,
    val createdAt: Timestamp,
    val updatedAt: Timestamp,
    val totalAmount: BigDecimal
) {

    fun toDomain() = Order(
        id = null,
        status = status,
        userId = userId,
        createdAt = createdAt,
        updatedAt = updatedAt,
        totalAmount = totalAmount
    )
}