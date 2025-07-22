package com.project.brothers_bakery.mysql.repositoryImpl

import com.project.brothers_bakery.domain.User
import com.project.brothers_bakery.dto.UserDTO
import com.project.brothers_bakery.mysql.repository.UserJpaRepository
import java.util.UUID
import org.springframework.stereotype.Repository

@Repository
class UserRepositoryImpl(private val userJpaRepository: UserJpaRepository) {

    fun create(userDto: UserDTO) {
        userJpaRepository.save(userDto.toDomain())
    }

    fun findByUserId(id: UUID): User? {
        return userJpaRepository.findByUserId(id)
    }

}