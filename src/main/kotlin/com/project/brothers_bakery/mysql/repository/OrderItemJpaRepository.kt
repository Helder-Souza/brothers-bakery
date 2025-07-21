package com.project.brothers_bakery.mysql.repository

import com.project.brothers_bakery.domain.OrderItem
import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface OrderItemJpaRepository : JpaRepository<OrderItem, UUID> {

    fun findOrderItemByOrderId(id: UUID): OrderItem?
}