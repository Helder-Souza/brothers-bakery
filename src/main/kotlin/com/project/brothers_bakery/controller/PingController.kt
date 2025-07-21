package com.project.brothers_bakery.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class PingController {

    @GetMapping("/ping")
    fun execute(): String {
        return "pong"
    }
}