package com.project.brothers_bakery.dto

import com.project.brothers_bakery.domain.CpfValidator
import com.project.brothers_bakery.domain.User
import org.springframework.security.crypto.bcrypt.BCrypt
import java.sql.Timestamp
import java.time.LocalDateTime
import java.util.UUID

data class UserDTO(
    val userId: UUID?,
    val name: String,
    val email: String,
    val cpf: String,
    val password: String,
    val address: String,
    val active: Boolean = true,
    val createdAt: Timestamp = Timestamp.valueOf(LocalDateTime.now()),
    val updatedAt: Timestamp = Timestamp.valueOf(LocalDateTime.now())
) {
    fun toDomain() = User(
        userId = null,
        name = name,
        email = email,
        cpf = cpf,
        password = password,
        address = address,
        active = active,
        createdAt = createdAt,
        updatedAt = updatedAt,
    )

    companion object {
        fun validateUser(userDTO: UserDTO): UserDTO {
            if (!userDTO.email.matches(Regex("^(.+)@(.+)$"))) throw RuntimeException("Email inválido")
            val validator = CpfValidator()
            if (!validator.validate(userDTO.cpf)) throw RuntimeException("Cpf inválido")
            return userDTO.copy(password = hashPassword(userDTO.password), active = true)
        }

        private fun hashPassword(password: String): String {
            return BCrypt.hashpw(password, BCrypt.gensalt())
        }

        fun checkPassword(password: String, hashed: String): Boolean {
            return BCrypt.checkpw(password, hashed)
        }
    }
}