package com.project.brothers_bakery.mysql.repositoryImpl

import com.project.brothers_bakery.dto.ProductDTO
import com.project.brothers_bakery.mysql.repository.ProductJpaRepository
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.api.Test
import java.math.BigDecimal
import java.sql.Timestamp
import java.time.LocalDateTime
import java.util.UUID
import kotlin.test.assertEquals

class ProductRepositoryImplTest {

    private val repository = mockk<ProductJpaRepository>()
    private val repositoryImpl = ProductRepositoryImpl(repository)

    @Test
    fun `should create a product`() {
        val input = ProductDTO(
            productId = null,
            name =  "Pão Frances",
            sku =  null,
            ean =  null,
            price = BigDecimal.valueOf(0.60),
            urlImage = null,
            discount =  null,
            createdAt = Timestamp.valueOf(LocalDateTime.now()),
            updatedAt = Timestamp.valueOf(LocalDateTime.now()),
            shipping =  BigDecimal.valueOf(0.05)
        )
        every { repository.save(input.toDomain()) } returns input.toDomain()
        repositoryImpl.createProduct(input)
        verify(exactly = 1) { repository.save(input.toDomain()) }
    }

    @Test
    fun `should update a product`() {
        val productId = UUID.randomUUID()
        val input = ProductDTO(
            productId = productId,
            name =  "Pão Frances",
            sku =  null,
            ean =  null,
            price = BigDecimal.valueOf(0.60),
            urlImage = null,
            discount =  null,
            createdAt = Timestamp.valueOf(LocalDateTime.now()),
            updatedAt = Timestamp.valueOf(LocalDateTime.now()),
            shipping =  BigDecimal.valueOf(0.05)
        )
        val productUpdated = input.copy(name = "Pão de leite")
        every { repository.updateProduct(productId) } returns productUpdated.toDomain()
        val result = repositoryImpl.updateProduct(productId)
        assertEquals("Pão de leite", result.name)
        verify(exactly = 1) { repository.updateProduct(input.productId!!) }
    }

    @Test
    fun `should return a product by id`() {
        val productId = UUID.randomUUID()
        val input = ProductDTO(
            productId = productId,
            name =  "Pão Frances",
            sku =  null,
            ean =  null,
            price = BigDecimal.valueOf(0.60),
            urlImage = null,
            discount =  null,
            createdAt = Timestamp.valueOf(LocalDateTime.now()),
            updatedAt = Timestamp.valueOf(LocalDateTime.now()),
            shipping =  BigDecimal.valueOf(0.05)
        )
        every { repository.findByProductId(productId) } returns input.toDomain()
        val result = repositoryImpl.findProductById(productId)
        assertEquals("Pão Frances", result?.name)
        verify(exactly = 1) { repository.findByProductId(input.productId!!) }
    }

    @Test
    fun `should return a product by name`() {
        val input = ProductDTO(
            productId = null,
            name =  "Pão Frances",
            sku =  null,
            ean =  null,
            price = BigDecimal.valueOf(0.60),
            urlImage = null,
            discount =  null,
            createdAt = Timestamp.valueOf(LocalDateTime.now()),
            updatedAt = Timestamp.valueOf(LocalDateTime.now()),
            shipping =  BigDecimal.valueOf(0.05)
        )
        every { repository.findByNameContainingIgnoreCase(input.name) } returns input.toDomain()
        val result = repositoryImpl.findByName(input.name)
        assertEquals("Pão Frances", result.name)
        verify(exactly = 1) { repository.findByNameContainingIgnoreCase(input.name) }
    }
}


