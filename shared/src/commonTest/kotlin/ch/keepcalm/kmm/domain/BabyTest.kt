package ch.keepcalm.kmm.domain

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotNull

class BabyTest {

    @Test
    fun `Should create Entity Baby with valid Name`() {
        val name = Name("John")
        val baby =  Baby(name)
        assertNotNull(name)
        assertEquals("John", baby.name.value)
    }
}