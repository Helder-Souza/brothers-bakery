package com.project.brothers_bakery.controller

import com.project.brothers_bakery.dto.ProductDTO
import com.project.brothers_bakery.usecase.ProductUseCase
import java.net.URI
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.servlet.support.ServletUriComponentsBuilder

@RestController
@RequestMapping("/products")
class ProductController(
    private val useCase: ProductUseCase
) {

    @PostMapping("/create-product")
    fun create(@RequestBody input: ProductDTO): ResponseEntity<ProductDTO> {
        val uri: URI = ServletUriComponentsBuilder
            .fromCurrentRequest()
            .path(ID)
            .buildAndExpand(useCase.create(input)!!.productId)
            .toUri()
        return ResponseEntity.created(uri).build()
    }

    companion object {
        private const val ID = "/{id}"
    }
}