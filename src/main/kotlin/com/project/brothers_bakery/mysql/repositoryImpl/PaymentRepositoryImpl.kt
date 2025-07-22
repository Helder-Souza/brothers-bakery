package com.project.brothers_bakery.mysql.repositoryImpl

import com.project.brothers_bakery.domain.Payment
import com.project.brothers_bakery.mysql.repository.PaymentJpaRepository
import com.project.brothers_bakery.dto.PaymentDTO
import java.util.UUID
import org.springframework.stereotype.Repository

@Repository
class PaymentRepositoryImpl(private val paymentJpaRepository: PaymentJpaRepository) {

    fun create(paymentDto: PaymentDTO) {
        paymentJpaRepository.save(paymentDto.toDomain())
    }

    fun findById(id: UUID): Payment? {
        return paymentJpaRepository.findByPaymentId(id)
    }

    fun updateStatus(status: String, id: UUID) {
        return paymentJpaRepository.updateStatusAndUpdatedAt(status, id)
    }
}