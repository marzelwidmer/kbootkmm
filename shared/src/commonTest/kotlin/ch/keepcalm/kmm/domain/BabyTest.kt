package ch.keepcalm.kmm.domain

import org.amshove.kluent.shouldBe
import org.amshove.kluent.shouldNotBe
import kotlin.test.Test

class BabyTest {

    @Test
    fun `Should create Entity Baby with valid Name`() {
        val name = Name("John")
        val baby =  Baby(name)
        baby shouldNotBe null
        baby.name.value shouldBe "John"
    }
}