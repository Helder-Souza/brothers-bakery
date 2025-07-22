package com.project.brothers_bakery.mysql.repository

import com.project.brothers_bakery.domain.Product
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import java.util.UUID

interface ProductJpaRepository : JpaRepository<Product, UUID> {

    fun findByProductId(id: UUID): Product?

    @Query("SELECT * FROM tb_products WHERE name = :name", nativeQuery = true)
    fun findByNameContainingIgnoreCase(name: String): Product

    @Query(
        "UPDATE tb_products SET " +
                "name = :name, " +
                "sku = :sku, " +
                "ean = :ean, " +
                "price = :price, " +
                "url_image = :urlImage, " +
                "discount = :discount, " +
                "updated_at = :CURRENT_TIME, " +
                "shipping = :shipping" +
                "WHERE product_id = :productId", nativeQuery = true)
    fun updateProduct(productId: UUID): Product

}