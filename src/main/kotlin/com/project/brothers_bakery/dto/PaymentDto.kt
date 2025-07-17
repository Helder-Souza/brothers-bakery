package com.project.brothers_bakery.dto

import com.project.brothers_bakery.domain.Payment
import java.math.BigDecimal
import java.sql.Timestamp
import java.util.UUID

data class PaymentDto(
    val id: UUID?,
    val orderId: UUID,
    val paymentMethod: String,
    val paymentStatus: String,
    val paidAmount: BigDecimal,
    val paymentDate: Timestamp,
) {
    companion object {

    }
    fun toDomain() = Payment(
        id = null,
        orderId = orderId,
        paymentMethod = paymentMethod,
        paymentStatus = paymentStatus,
        paidAmount = paidAmount,
        paymentDate = paymentDate,
    )
}