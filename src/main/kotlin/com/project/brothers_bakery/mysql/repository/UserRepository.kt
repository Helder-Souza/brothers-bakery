package com.project.brothers_bakery.mysql.repository

import com.project.brothers_bakery.domain.User
import java.util.UUID
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository : JpaRepository<User, UUID> {

    fun findByUserId(id: UUID): User?
}