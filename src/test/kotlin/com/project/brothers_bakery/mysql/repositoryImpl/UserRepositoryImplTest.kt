package com.project.brothers_bakery.mysql.repositoryImpl

import com.project.brothers_bakery.dto.UserDTO
import com.project.brothers_bakery.mysql.repository.UserJpaRepository
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import java.sql.Timestamp
import java.time.LocalDateTime
import kotlin.test.assertEquals
import kotlin.test.assertNotNull
import org.junit.jupiter.api.Test


class UserRepositoryImplTest {

    private val userRepository = mockk<UserJpaRepository>()
    private val userRepositoryImpl = UserRepositoryImpl(userRepository)

    @Test
    fun `should create a User`() {

        val user = UserDTO(
            userId = null,
            name = "test user",
            email = "email@email.com",
            cpf = "11122233344",
            password = "1234",
            address = "Rua do Pão",
            updatedAt = Timestamp.valueOf(LocalDateTime.now())
        )

        every { userRepository.save(user.toDomain()) } returns user.toDomain()

        userRepositoryImpl.create(user)

        verify(exactly = 1) { userRepository.save(user.toDomain()) }
    }

    @Test
    fun `should return a User by Email`() {
        val user = UserDTO(
            userId = null,
            name = "test user",
            email = "email@email.com",
            cpf = "11122233344",
            password = "1234",
            address = "Rua do Pão",
            updatedAt = Timestamp.valueOf(LocalDateTime.now())
        )

        every { userRepository.findUserByEmailContainingIgnoreCase(user.email) } returns user.toDomain()

        val result = userRepositoryImpl.findByEmail(user.email)

        verify(exactly = 1) { userRepository.findUserByEmailContainingIgnoreCase(user.email) }
        assertNotNull(result)
        assertEquals(user.email, result.email)
    }
}