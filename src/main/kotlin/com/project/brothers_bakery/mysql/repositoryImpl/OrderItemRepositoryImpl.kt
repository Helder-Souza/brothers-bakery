package com.project.brothers_bakery.mysql.repositoryImpl

import com.project.brothers_bakery.domain.OrderItem
import com.project.brothers_bakery.dto.OrderItemDTO
import com.project.brothers_bakery.mysql.repository.OrderItemJpaRepository
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
class OrderItemRepositoryImpl(private val orderItemJpaRepository: OrderItemJpaRepository) {

    fun findOrderItemByOrderId(orderId: UUID) : OrderItem? {
        return orderItemJpaRepository.findOrderItemByOrderId(orderId)
    }

    fun createOrderItem(orderItemDTO: OrderItemDTO): OrderItemDTO {
        return orderItemJpaRepository.save(orderItemDTO.toDomain()).toDTO()
    }
}