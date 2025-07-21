package com.project.brothers_bakery.domain

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
)
