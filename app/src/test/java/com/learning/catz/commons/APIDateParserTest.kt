package com.learning.catz.commons

import com.learning.catz.base.BaseTest
import io.mockk.spyk
import junit.framework.TestCase.assertEquals
import org.junit.Test
import java.text.DateFormat
import java.util.*

class APIDateParserTest : BaseTest() {

    private val apiDateParser by lazy {
        spyk(
            APIDateParser()
        )
    }

    @Test
    fun `GIVEN a fake date string WHEN call for parse THEN assert date formatted`() {
        // Given
        val originalDate = "2020-08-23T20:20:01.611Z"
        val expectedDate = "Aug 23, 2020 5:20:01 PM"
        val dateFormatter = DateFormat.getDateTimeInstance(
            DateFormat.MEDIUM,
            DateFormat.MEDIUM, Locale.US
        )

        // When
        val dateResult = apiDateParser.parse(originalDate)
        val stringResult = dateFormatter.format(dateResult)

        // Then
        assertEquals(expectedDate, stringResult)
    }
}