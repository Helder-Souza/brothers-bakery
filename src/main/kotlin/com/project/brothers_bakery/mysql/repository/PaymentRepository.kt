package com.project.brothers_bakery.mysql.repository

import com.project.brothers_bakery.domain.Payment
import java.util.UUID
import org.springframework.data.jpa.repository.JpaRepository

interface PaymentRepository : JpaRepository<Payment, UUID> {

}