package com.project.brothers_bakery.mysql.repositoryImpl

import com.project.brothers_bakery.domain.Product
import com.project.brothers_bakery.dto.ProductDTO
import com.project.brothers_bakery.mysql.repository.ProductJpaRepository
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
class ProductRepositoryImpl(private val productJpaRepository: ProductJpaRepository) {

    fun findProductById(productId: UUID) : Product? {
        return productJpaRepository.findByProductId(productId)
    }

    fun findAllProducts(): List<ProductDTO>? {
        return productJpaRepository.findAll().map { it.toDto() }
    }

    fun findByName(name: String) : Product {
        return productJpaRepository.findByNameContainingIgnoreCase(name)
    }

    fun createProduct(productDTO: ProductDTO): ProductDTO? {
        return productJpaRepository.save(productDTO.toDomain()).toDto()
    }

    fun updateProduct(productId: UUID): Product {
        return productJpaRepository.updateProduct(productId)
    }
}