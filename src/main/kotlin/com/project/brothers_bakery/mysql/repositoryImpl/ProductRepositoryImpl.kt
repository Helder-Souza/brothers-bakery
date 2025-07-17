package com.project.brothers_bakery.mysql.repositoryImpl

import com.project.brothers_bakery.domain.Product
import com.project.brothers_bakery.dto.ProductDTO
import com.project.brothers_bakery.mysql.repository.ProductRepository
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
class ProductRepositoryImpl(private val productRepository: ProductRepository) {

    fun findProductById(productId: UUID) : Product? {
        return productRepository.findByProductId(productId)
    }

    fun findByName(name: String) : Product {
        return productRepository.findByNameContainingIgnoreCase(name)
    }

    fun createProduct(productDTO: ProductDTO) {
        productRepository.save(productDTO.toDomain())
    }

    fun updateProduct(productId: UUID): Product {
        return productRepository.updateProduct(productId)
    }
}