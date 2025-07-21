package com.project.brothers_bakery.mysql.repository

import com.project.brothers_bakery.domain.Order
import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface OrderRepository : JpaRepository<Order, UUID> {

    fun findByOrderId(id: UUID): Order?
}