package com.project.brothers_bakery.controller

import kotlin.test.assertEquals
import org.junit.jupiter.api.Test

class PingControllerTest {

    private val pingController = PingController()

    @Test
    fun `should return pong`() {
        assertEquals("pong", pingController.execute())
    }
}