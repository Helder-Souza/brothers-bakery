package com.project.brothers_bakery.usecase

import com.project.brothers_bakery.dto.ProductDTO
import com.project.brothers_bakery.mysql.repositoryImpl.ProductRepositoryImpl
import org.springframework.stereotype.Component

@Component
class ProductUseCase(
    private val productRepositoryImpl: ProductRepositoryImpl
) {

    fun create(input: ProductDTO): ProductDTO? {
        return productRepositoryImpl.createProduct(input)
    }
}