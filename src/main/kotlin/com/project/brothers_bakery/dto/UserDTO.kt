package com.project.brothers_bakery.dto

import com.project.brothers_bakery.domain.User
import java.sql.Timestamp
import java.util.UUID

data class UserDTO(
    val userId: UUID?,
    val name: String,
    val email: String,
    val cpf: String,
    val password: String,
    val createdAt: Timestamp,
    val updatedAt: Timestamp
) {
    fun toDomain() = User(
        userId = null,
        name = name,
        email = email,
        cpf = cpf,
        password = password,
        createdAt = createdAt,
        updatedAt = updatedAt,
    )
}
