package com.learning.catz.facts

import io.mockk.mockk
import org.junit.Assert.*
import org.junit.Test
import java.util.*

class FactDiffCallbackTest {

    @Test
    fun `given two objects with same id when compare them by id then return true`() {
        val factA = Fact("1", mockk(), "")
        val factB = Fact("1", mockk(), "")

        val result = FactDiffCallback().areItemsTheSame(factA, factB)

        assertTrue(result)
    }

    @Test
    fun `given two objects with different id when compare them then return false`() {
        val factA = Fact("1", mockk(), "")
        val factB = Fact("2", mockk(), "")

        val result = FactDiffCallback().areItemsTheSame(factA, factB)

        assertFalse(result)
    }

    @Test
    fun `given two objects with same content when compare them by content then return true`() {
        val id = "1"
        val date = mockk<Date>()
        val content = "Test"
        val factA = Fact(id, date, content)
        val factB = Fact(id, date, content)

        val result = FactDiffCallback().areContentsTheSame(factA, factB)

        assertTrue(result)
    }

    @Test
    fun `given two objects with different content when compare them by content then return false`() {
        val id = "1"
        val date = mockk<Date>()
        val content = "Test"
        val factBase = Fact(id, date, content)
        val factWithWrongId = Fact("2", date, content)
        val factWithWrongDate = Fact(id, Date(0), content)
        val factWithWrongContent = Fact(id, date, "I'm wrong")

        val result1 = FactDiffCallback().areContentsTheSame(factBase, factWithWrongId)
        val result2 = FactDiffCallback().areContentsTheSame(factBase, factWithWrongDate)
        val result3 = FactDiffCallback().areContentsTheSame(factBase, factWithWrongContent)

        assertFalse(result1)
        assertFalse(result2)
        assertFalse(result3)
    }

}