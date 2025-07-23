package com.project.brothers_bakery.controller

import com.project.brothers_bakery.dto.UserDTO
import com.project.brothers_bakery.usecase.UserUseCase
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.servlet.support.ServletUriComponentsBuilder
import java.net.URI

@RestController
@RequestMapping("/user")
class UserController(private val useCase: UserUseCase) {

    @PostMapping
    fun createUser(@RequestBody userDTO: UserDTO): ResponseEntity<UserDTO> {
        val uri: URI = ServletUriComponentsBuilder
            .fromCurrentRequest()
            .path(ID)
            .buildAndExpand(useCase.createUser(userDTO).userId)
            .toUri()
        return ResponseEntity.created(uri).build()
    }

    companion object {
        const val ID = "/{id}"
    }
}