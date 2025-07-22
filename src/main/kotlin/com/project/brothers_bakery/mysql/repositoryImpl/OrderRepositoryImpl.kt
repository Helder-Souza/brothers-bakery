package com.project.brothers_bakery.mysql.repositoryImpl

import com.project.brothers_bakery.domain.Order
import com.project.brothers_bakery.dto.OrderDTO
import com.project.brothers_bakery.mysql.repository.OrderJpaRepository
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
class OrderRepositoryImpl(private val orderRepository: OrderJpaRepository) {

    fun findOrderById(orderId: UUID) : Order? {
        return orderRepository.findByOrderId(orderId)
    }

    fun createOrder(orderDTO: OrderDTO) {
        orderRepository.save(orderDTO.toDomain())
    }
}