package com.project.brothers_bakery.mysql.repositoryImpl

import com.project.brothers_bakery.dto.UserDTO
import com.project.brothers_bakery.mysql.repository.UserJpaRepository
import org.springframework.stereotype.Repository

@Repository
class UserRepositoryImpl(private val userJpaRepository: UserJpaRepository) {

    fun create(userDto: UserDTO): UserDTO {
        return userJpaRepository.save(userDto.toDomain()).toDTO()
    }

    fun findByEmail(email: String): UserDTO? {
        return userJpaRepository.findUserByEmailContainingIgnoreCase(email)?.toDTO()
    }

}