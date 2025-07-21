package com.project.brothers_bakery.domain

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.sql.Timestamp
import java.util.UUID

@Entity
@Table(name = "tb_users")
data class User(
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    val userId: UUID?,
    val name: String,
    val email: String,
    val cpf: String,
    val password: String,
    val createdAt: Timestamp,
    val updatedAt: Timestamp
)
