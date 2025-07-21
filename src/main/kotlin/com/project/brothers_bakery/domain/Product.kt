package com.project.brothers_bakery.domain

import com.project.brothers_bakery.dto.ProductDTO
import jakarta.persistence.GenerationType
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.math.BigDecimal
import java.sql.Timestamp
import java.util.UUID

@Entity
@Table(name = "tb_products")
data class Product(
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    val id: UUID?,
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
    fun toDto() = ProductDTO(
        id = id,
        name = name,
        sku = sku,
        ean = ean,
        price = price,
        urlImage = urlImage,
        discount = discount,
        createdAt = createdAt,
        updatedAt = updatedAt,
        shipping = shipping,
    )
}
