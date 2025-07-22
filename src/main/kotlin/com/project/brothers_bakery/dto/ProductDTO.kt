package com.project.brothers_bakery.dto

import com.project.brothers_bakery.domain.Product
import java.math.BigDecimal
import java.sql.Timestamp
import java.util.UUID

data class ProductDTO(
    val productId: UUID?,
    val name: String,
    val sku: String?,
    val ean: String?,
    val price: BigDecimal,
    val urlImage: String?,
    val discount: Int?,
    val createdAt: Timestamp,
    val updatedAt: Timestamp,
    val shipping: BigDecimal
) {

    fun toDomain() = Product(
        productId = null,
        name = name,
        sku = sku,
        ean = ean,
        price = price,
        urlImage = urlImage,
        discount = discount,
        createdAt = createdAt,
        updatedAt = updatedAt,
        shipping = shipping
    )
}