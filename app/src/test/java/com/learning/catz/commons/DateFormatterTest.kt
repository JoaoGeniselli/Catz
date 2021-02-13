package com.learning.catz.commons

import com.learning.catz.base.BaseTest
import io.mockk.spyk
import junit.framework.TestCase
import junit.framework.TestCase.assertEquals
import org.junit.Test
import java.text.DateFormat
import java.util.*

class DateFormatterTest : BaseTest(){

    private val dateFormatter by lazy {
        spyk(
            DateFormatter()
        )
    }

    @Test
    fun `GIVEN expected date WHEN calling for formatting THEN assert date formatted`(){
        // Given
        val apiDateParser = APIDateParser()
        val date: Date = apiDateParser.parse("2020-08-23T20:20:01.611Z")
        val expectedDateSting = DateFormat.getDateTimeInstance().format(date)

        // When
        val resultDateString = dateFormatter.format(date)

        // Then
        assertEquals(expectedDateSting, resultDateString)

    }
}