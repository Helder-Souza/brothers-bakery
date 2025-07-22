package com.project.brothers_bakery.controller

import com.fasterxml.jackson.databind.ObjectMapper
import com.project.brothers_bakery.config.IntegrationTest
import com.project.brothers_bakery.dto.ProductDTO
import com.project.brothers_bakery.mysql.repositoryImpl.ProductRepositoryImpl
import java.math.BigDecimal
import kotlin.test.assertEquals
import kotlin.test.assertNotNull
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.http.HttpEntity
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType

class ProductControllerTest : IntegrationTest() {

    @Autowired
    lateinit var restTemplate: TestRestTemplate

    @Autowired
    lateinit var productRepositoryImpl: ProductRepositoryImpl

    @Autowired
    lateinit var objectMapper: ObjectMapper

    @Test
    fun `should create and persist a product`() {
        val inputStream = javaClass.classLoader.getResourceAsStream("files/payloads/product_input.json")
        val dto = objectMapper.readValue(inputStream, ProductDTO::class.java)

        val headers = HttpHeaders()
        headers.contentType = MediaType.APPLICATION_JSON

        val request = HttpEntity(dto, headers)

        val response = restTemplate.postForEntity("/create-product", request, ProductDTO::class.java)

        assertEquals(HttpStatus.CREATED,response.statusCode)

        val products = productRepositoryImpl.findAllProducts()
        val productDTO = products?.first()
        assertEquals(1, products!!.size)
        assertNotNull(productDTO)
        assertEquals("12345", productDTO.sku)
        assertEquals("Pão Francês", productDTO.name)
        assertEquals(BigDecimal.valueOf(0.60).setScale(2), productDTO.price)
    }

}