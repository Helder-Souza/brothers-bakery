package com.project.brothers_bakery.mysql.repository

import com.project.brothers_bakery.domain.Payment
import jakarta.transaction.Transactional
import java.util.UUID
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query

interface PaymentJpaRepository : JpaRepository<Payment, UUID> {

    @Modifying
    @Transactional
    @Query("Update tb_payments SET status = :status, updatedAt = CURRENT_TIMESTAMP WHERE payment_id = :id", nativeQuery = true)
    fun updateStatusAndUpdatedAt(status: String, id: UUID)

    fun findByPaymentId(id: UUID): Payment?
}