package com.project.brothers_bakery.mysql.repositoryImpl

import io.mockk.mockk
import io.mockk.every
import io.mockk.verify
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class MyServiceTest {
    @Test
    fun testMockk() {
        val mock = mockk<MyDependency>()
        every { mock.doSomething() } returns "mocked"

        val result = mock.doSomething()
        assertEquals("mocked", result)
        verify { mock.doSomething() }
    }
}

class MyDependency {
    fun doSomething(): String = "real"
}


