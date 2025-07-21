package com.project.brothers_bakery.mysql.repositoryImpl

import com.project.brothers_bakery.domain.OrderItem
import com.project.brothers_bakery.dto.OrderItemDTO
import com.project.brothers_bakery.mysql.repository.OrderItemRepository
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
class OrderItemRepositoryImpl(private val orderItemRepository: OrderItemRepository) {

    fun findOrderItemByOrderId(orderId: UUID) : OrderItem? {
        return orderItemRepository.findOrderItemByOrderId(orderId)
    }

    fun createOrderItem(orderItemDTO: OrderItemDTO): OrderItemDTO {
        return orderItemRepository.save(orderItemDTO.toDomain()).toDTO()
    }
}