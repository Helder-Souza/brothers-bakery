package com.project.brothers_bakery.usecase

import com.project.brothers_bakery.dto.UserDTO
import com.project.brothers_bakery.mysql.repositoryImpl.UserRepositoryImpl
import org.springframework.stereotype.Component

@Component
class UserUseCase(private val repositoryImpl: UserRepositoryImpl) {

    fun createUser(userDTO: UserDTO): UserDTO {
        if(findUserByEmail(userDTO.email) != null) throw RuntimeException("Usuario ja existe")
        val account = UserDTO.validateUser(userDTO)
        return repositoryImpl.create(account)
    }

    fun findUserByEmail(email: String): UserDTO? {
        return repositoryImpl.findByEmail(email)
    }

//    fun findUserById(id: UUID): UserDTO? {
//        return repositoryImpl.findByUserId(id);
//    }
}