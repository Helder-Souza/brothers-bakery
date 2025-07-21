package com.project.brothers_bakery.mysql.repositoryImpl

import com.project.brothers_bakery.domain.User
import com.project.brothers_bakery.dto.UserDto
import com.project.brothers_bakery.mysql.repository.UserRepository
import java.util.UUID
import org.springframework.stereotype.Repository

@Repository
class UserRepositoryImpl(private val userRepository: UserRepository) {

    fun create(userDto: UserDto) {
        userRepository.save(userDto.toDomain())
    }

    fun findById(id: UUID): User? {
        return userRepository.findByUserId(id)
    }

}