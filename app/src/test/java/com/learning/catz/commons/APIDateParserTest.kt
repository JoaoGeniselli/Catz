package com.learning.catz.commons

import org.junit.Assert.assertEquals
import org.junit.Test
import java.text.ParseException

class APIDateParserTest {

    @Test
    fun `given valid api date when parse it then return correct date object`() {
        val apiDate = "2021-01-24T16:00:52.000Z"
        val result = APIDateParser().parse(apiDate)
        assertEquals(1611504052000, result.time)
    }

    @Test(expected = ParseException::class)
    fun `given null api date when parse it then break parse`() {
        val apiDate = null
        APIDateParser().parse(apiDate)
    }

    @Test(expected = ParseException::class)
    fun `given invalid api date when parse it then break parse`() {
        val apiDate = "-01-24T16:00:52.000Z"
        APIDateParser().parse(apiDate)
    }
}