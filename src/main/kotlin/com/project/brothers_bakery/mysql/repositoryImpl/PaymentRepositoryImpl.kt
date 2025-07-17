package com.project.brothers_bakery.mysql.repositoryImpl

import com.project.brothers_bakery.mysql.repository.PaymentRepository
import com.project.brothers_bakery.dto.PaymentDto
import java.util.UUID
import org.springframework.stereotype.Repository

@Repository
class PaymentRepositoryImpl(private val paymentRepository: PaymentRepository) {

    fun create(paymentDto: PaymentDto) {
        paymentRepository.save(paymentDto.toDomain())
    }

    fun findById(id: UUID) {
        paymentRepository.findById(id)
    }

    fun updateStatus(status: String, id: UUID) {
        return paymentRepository.updateStatusAndUpdatedAt(status, id)
    }
}