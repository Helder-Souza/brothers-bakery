package com.project.brothers_bakery.mysql.repositoryImpl

import com.project.brothers_bakery.dto.OrderItemDTO
import com.project.brothers_bakery.mysql.repository.OrderItemRepository
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.api.Test
import java.math.BigDecimal
import java.util.UUID
import kotlin.test.assertEquals

class OrderItemRepositoryImplTest {

    private val repository = mockk<OrderItemRepository>()
    private val repositoryImpl = OrderItemRepositoryImpl(repository)

    @Test
    fun `should create a orderItem`() {
        val input = OrderItemDTO(
            id = null,
            orderId = UUID.randomUUID(),
            productName = "Broa de milho",
            quantity = 3,
            price = BigDecimal.valueOf(2.10)
        )
        every { repository.save(input.toDomain()) } returns input.toDomain()
        repositoryImpl.createOrderItem(input)
        verify(exactly = 1) { repository.save(input.toDomain()) }
    }

    @Test
    fun `should return a orderItem by orderId`() {
        val orderId = UUID.randomUUID()
        val orderItemId = UUID.randomUUID()
        val input = OrderItemDTO(
            id = orderItemId,
            orderId = orderId,
            productName = "Broa de milho",
            quantity = 3,
            price = BigDecimal.valueOf(2.10)
        )
        every { repository.findOrderItemByOrderId(orderId) } returns input.toDomain()
        val result = repositoryImpl.findOrderItemByOrderId(orderId)
        assertEquals(BigDecimal.valueOf(2.10), result?.price)
        verify(exactly = 1) { repository.findOrderItemByOrderId(input.orderId) }
    }
}


