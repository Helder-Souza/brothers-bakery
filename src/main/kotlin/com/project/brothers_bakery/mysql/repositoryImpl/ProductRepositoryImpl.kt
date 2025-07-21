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

    fun findByName(name: String) : Product {
        return productJpaRepository.findByNameContainingIgnoreCase(name)
    }

    fun createProduct(productDTO: ProductDTO) {
        productJpaRepository.save(productDTO.toDomain())
    }

    fun updateProduct(productId: UUID): Product {
        return productJpaRepository.updateProduct(productId)
    }
}