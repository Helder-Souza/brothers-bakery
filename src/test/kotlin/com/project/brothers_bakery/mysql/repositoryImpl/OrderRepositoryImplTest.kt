package com.project.brothers_bakery.mysql.repositoryImpl

import com.project.brothers_bakery.dto.OrderDTO
import com.project.brothers_bakery.mysql.repository.OrderRepository
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.api.Test
import java.math.BigDecimal
import java.sql.Timestamp
import java.time.LocalDateTime
import java.util.UUID
import kotlin.test.assertEquals

class OrderRepositoryImplTest {

    private val repository = mockk<OrderRepository>()
    private val repositoryImpl = OrderRepositoryImpl(repository)

    @Test
    fun `should create a order`() {
        val input = OrderDTO(
            id = null,
            status =  "created",
            userId =  UUID.randomUUID(),
            createdAt = Timestamp.valueOf(LocalDateTime.now()),
            updatedAt = Timestamp.valueOf(LocalDateTime.now()),
            totalAmount =  BigDecimal.valueOf(0.05)
        )
        every { repository.save(input.toDomain()) } returns input.toDomain()
        repositoryImpl.createOrder(input)
        verify(exactly = 1) { repository.save(input.toDomain()) }
    }

    @Test
    fun `should return a order by id`() {
        val orderId = UUID.randomUUID()
        val input = OrderDTO(
            id = orderId,
            status =  "created",
            userId =  UUID.randomUUID(),
            createdAt = Timestamp.valueOf(LocalDateTime.now()),
            updatedAt = Timestamp.valueOf(LocalDateTime.now()),
            totalAmount =  BigDecimal.valueOf(0.05)
        )
        every { repository.findByOrderId(orderId) } returns input.toDomain()
        val result = repositoryImpl.findOrderById(orderId)
        assertEquals("created", result?.status)
        verify(exactly = 1) { repository.findByOrderId(input.id!!) }
    }
}


