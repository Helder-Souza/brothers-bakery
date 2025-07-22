package com.project.brothers_bakery.controller

import com.fasterxml.jackson.databind.ObjectMapper
import com.project.brothers_bakery.config.IntegrationTest
import com.project.brothers_bakery.dto.ProductDTO
import com.project.brothers_bakery.mysql.repository.ProductRepository
import com.project.brothers_bakery.mysql.repositoryImpl.ProductRepositoryImpl
import kotlin.test.assertEquals
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.http.HttpEntity
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.test.context.ActiveProfiles
import readJsonAs

@SpringBootTest
@ActiveProfiles("test")
class ProductControllerTest : IntegrationTest() {

    @Autowired
    lateinit var restTemplate: TestRestTemplate

    @Autowired
    lateinit var productRepositoryImpl: ProductRepositoryImpl

    @Autowired
    lateinit var productRepository: ProductRepository

    @Autowired
    lateinit var objectMapper: ObjectMapper

    @Test
    fun `should create and persist a product`() {
        val dto: ProductDTO = objectMapper.readJsonAs("payloads/product_input.json")

        val headers = HttpHeaders()
        headers.contentType = MediaType.APPLICATION_JSON

        val request = HttpEntity(dto, headers)

        val response = restTemplate.postForEntity("/products", request, ProductDTO::class.java)

        assertEquals(HttpStatus.CREATED,response.statusCode)
        assertEquals("Pão Francês", response.body?.name)

        val produtos = productRepositoryImpl.findAllProducts()
        assertEquals(1, produtos!!.size)
        assertEquals("12345", produtos.first().sku)
    }

}