package com.project.brothers_bakery.mysql.repositoryImpl

import com.project.brothers_bakery.dto.PaymentDTO
import com.project.brothers_bakery.mysql.repository.PaymentJpaRepository
import io.mockk.every
import io.mockk.justRun
import io.mockk.mockk
import io.mockk.verify
import java.math.BigDecimal
import java.sql.Timestamp
import java.time.LocalDateTime
import java.util.UUID
import org.junit.jupiter.api.Test

class PaymentRepositoryImplTest {

    private val paymentRepository = mockk<PaymentJpaRepository>()
    private val paymentRepositoryImpl = PaymentRepositoryImpl(paymentRepository)

    @Test
    fun `should create a payment`() {
        val orderId = UUID.randomUUID()

        val paymentDto = PaymentDTO(
            paymentId = null,
            orderId = orderId,
            paymentMethod = "money",
            paymentStatus = "approved",
            paidAmount = BigDecimal.TEN,
            paymentDate = Timestamp.valueOf(LocalDateTime.now())
        )

        every { paymentRepository.save(paymentDto.toDomain()) } returns paymentDto.toDomain()

        paymentRepositoryImpl.create(paymentDto)

        verify(exactly = 1) { paymentRepository.save(paymentDto.toDomain()) }
    }

    @Test
    fun `should return payment by id`() {
        val paymentId = UUID.randomUUID()
        val orderId = UUID.randomUUID()

        val paymentDto = PaymentDTO(
            paymentId = paymentId,
            orderId = orderId,
            paymentMethod = "money",
            paymentStatus = "approved",
            paidAmount = BigDecimal.TEN,
            paymentDate = Timestamp.valueOf(LocalDateTime.now())
        )

        every { paymentRepository.findByPaymentId(paymentId) } returns paymentDto.toDomain()

        paymentRepositoryImpl.findById(paymentId)

        verify(exactly = 1) { paymentRepository.findByPaymentId(paymentId) }
    }

    @Test
    fun `should update payment status`() {
        val paymentId = UUID.randomUUID()
        val newStatus = "approved"

        justRun { paymentRepository.updateStatusAndUpdatedAt(newStatus, paymentId) }

        paymentRepositoryImpl.updateStatus(newStatus, paymentId)

        verify(exactly = 1) { paymentRepository.updateStatusAndUpdatedAt(newStatus, paymentId) }
    }

}