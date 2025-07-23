package com.project.brothers_bakery.controller

import com.fasterxml.jackson.databind.ObjectMapper
import com.project.brothers_bakery.config.IntegrationTest
import com.project.brothers_bakery.dto.UserDTO
import com.project.brothers_bakery.mysql.repositoryImpl.UserRepositoryImpl
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.http.HttpEntity
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import kotlin.test.assertTrue
import kotlin.test.assertEquals
import kotlin.test.assertNotNull

class UserControllerTest : IntegrationTest() {

    @Autowired
    lateinit var restTemplate: TestRestTemplate

    @Autowired
    lateinit var userRepositoryImpl: UserRepositoryImpl

    @Autowired
    lateinit var objectMapper: ObjectMapper

//    @Test
//    fun `should create and persist an user`() {
//        val inputStream = javaClass.classLoader.getResourceAsStream("files/payloads/user_input.json")
//        val dto = objectMapper.readValue(inputStream, UserDTO::class.java)
//
//        val headers = HttpHeaders()
//        headers.contentType = MediaType.APPLICATION_JSON
//
//        val request = HttpEntity(dto, headers)
//
//        val response = restTemplate.postForEntity("/user", request, UserDTO::class.java)
//
//        assertEquals(HttpStatus.CREATED, response.statusCode)
//
//        val user = userRepositoryImpl.findByEmail(dto.email)
//        assertNotNull(user)
//        assertEquals("Amarildo", user.name)
//        assertEquals("amarildo.contato@gmail.com", user.email)
//        assertTrue(UserDTO.checkPassword("senhaPadaria", user.password))
//    }
}