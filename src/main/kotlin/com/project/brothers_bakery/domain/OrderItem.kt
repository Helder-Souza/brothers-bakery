package com.project.brothers_bakery.domain

import com.project.brothers_bakery.dto.OrderItemDTO
import jakarta.persistence.GenerationType
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.math.BigDecimal
import java.util.UUID

@Entity
@Table(name = "tb_order_items")
data class OrderItem(
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    val orderItemId: UUID?,
    val orderId: UUID,
    val productName: String,
    val quantity: Int,
    val price: BigDecimal
) {
    fun toDTO() = OrderItemDTO(
        orderItemId = orderItemId,
        orderId = orderId,
        productName = productName,
        quantity = quantity,
        price = price
    )
}
