package ch.keepcalm.kmm.domain

import kotlin.test.Test
import kotlin.test.assertFailsWith
import kotlin.test.assertNotNull

class NameTest {

    @Test
    fun `Should create Value Object Name`() {
        val name = Name("John")
        assertNotNull(name)
    }

    @Test
    fun `Name should have max size of 10 characters`() {
        val name = Name("Hans-Peter")
        assertNotNull(name)
    }

    @Test
    fun `Name should have a size of more then 2 characters`() {
        val name = Name("Hu")
        assertNotNull(name)
    }

    @Test
    fun `Should throw a IllegalArgumentException for a Name with less characters then 2`() {
        assertFailsWith(
            exceptionClass = IllegalArgumentException::class,
            block = {
                Name("H")
            }
        )
    }

    @Test
    fun `Should throw a IllegalArgumentException for a Name with more then 10 characters`() {
        assertFailsWith(
            exceptionClass = IllegalArgumentException::class,
            block = {
                Name("Hans-Peter-Adalbert")
            }
        )
    }
}