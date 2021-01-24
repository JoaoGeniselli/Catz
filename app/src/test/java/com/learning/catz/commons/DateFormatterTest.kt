package com.learning.catz.commons

import org.junit.Assert.*
import org.junit.Test
import java.util.*

class DateFormatterTest {

    @Test
    fun `given valid date when format it then return date and time based on locale`() {
        val brazil = Locale("pt", "br")
        Locale.setDefault(brazil)
        val result = DateFormatter().format(Date(1611505800000))
        assertEquals("24/01/2021 14:30:00", result)
    }
}
