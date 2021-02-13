package com.learning.catz.facts

import com.learning.catz.base.BaseTest
import com.learning.catz.commons.APIDateParser
import com.learning.catz.network.CatzAPI
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.MockK
import io.mockk.spyk
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class FactsRepositoryTest : BaseTest() {

    @MockK
    private lateinit var apiDateParser: APIDateParser

    @MockK
    private lateinit var api: CatzAPI

    private val factsRepository by lazy {
        spyk(
            FactsRepository(
                apiDateParser = apiDateParser,
                api = api
            )
        )
    }

    @Before
    fun onSetup() {
        MockKAnnotations.init(this, relaxUnitFun = true)
    }

    @Test
    fun `GIVEN fake valid fact list WHEN call for api THEN assert list valid`() = runBlocking {
        // Given
        val requestResult = mutableListOf<Fact>()

        coEvery {
            factsRepository.facts
        } returns flow { emit(FAKE_FACT_LIST) }

        // When
        factsRepository.facts.collect { requestResult.addAll(it) }

        // Then
        assertEquals(FAKE_FACT_LIST, requestResult.toList())

    }

    companion object {
        private val FAKE_FACT_LIST = listOf(
            Fact(
                id = "response 01",
                content = "Fact 01",
                updatedDate = APIDateParser().parse("2020-08-23T20:20:01.611Z")
            ),
            Fact(
                id = "response 02",
                content = "Fact 02",
                updatedDate = APIDateParser().parse("2020-08-24T20:20:01.611Z")
            ),
            Fact(
                id = "response 03",
                content = "Fact 03",
                updatedDate = APIDateParser().parse("2020-08-25T20:20:01.611Z")
            )
        )
    }
}