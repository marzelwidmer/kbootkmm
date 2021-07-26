package ch.keepcalm.kmm.domain

import org.amshove.kluent.shouldBe
import org.amshove.kluent.shouldBeLessOrEqualTo
import org.amshove.kluent.shouldNotBeNull
import kotlin.test.Test
import kotlin.test.assertFailsWith

class NameTest {

    @Test
    fun `Should create Value Object Name`() {
        val name = Name("John")
        name.shouldNotBeNull()
        name.value `shouldBe` "John"
    }

    @Test
    fun `Name should have max size of 10 characters`() {
        val name = Name("Hans-Peter")
        name.shouldNotBeNull()
        name.value.length shouldBeLessOrEqualTo 10
    }

    @Test
    fun `Name should have a size of more then 2 characters`() {
        val name = Name("Hu")
        name.shouldNotBeNull()
        name.value.length shouldBeLessOrEqualTo 2
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