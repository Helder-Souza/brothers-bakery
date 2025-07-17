package com.project.brothers_bakery.mysql.repository

import com.project.brothers_bakery.domain.Payment
import jakarta.transaction.Transactional
import java.util.UUID
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query

interface PaymentRepository : JpaRepository<Payment, UUID> {

    @Modifying
    @Transactional
    @Query("Update tb SET status = :status, t.updatedAt = CURRENT_TIMESTAMP WHERE t.id = :id")
    fun updateStatusAndUpdatedAt(status: String, id: UUID)
}