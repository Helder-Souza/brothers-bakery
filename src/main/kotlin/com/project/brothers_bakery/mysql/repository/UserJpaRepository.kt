package com.project.brothers_bakery.mysql.repository

import com.project.brothers_bakery.domain.User
import java.util.UUID
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface UserJpaRepository : JpaRepository<User, UUID> {

    @Query("SELECT * FROM tb_users WHERE email = :email", nativeQuery = true)
    fun findUserByEmailContainingIgnoreCase(email: String): User?
}