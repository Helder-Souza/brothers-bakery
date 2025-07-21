package com.project.brothers_bakery.dto

import com.project.brothers_bakery.domain.OrderItem
import java.math.BigDecimal
import java.util.UUID

data class OrderItemDTO(
    val orderItemId: UUID?,
    val orderId: UUID,
    val productName: String,
    val quantity: Int,
    val price: BigDecimal
) {

    fun toDomain() = OrderItem(
        orderItemId = null,
        orderId = orderId,
        productName = productName,
        quantity = quantity,
        price = price
    )
}