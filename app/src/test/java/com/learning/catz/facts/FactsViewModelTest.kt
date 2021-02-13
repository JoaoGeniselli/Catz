package com.learning.catz.facts

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.learning.catz.base.BaseViewModelTest
import com.learning.catz.commons.APIDateParser
import io.mockk.every
import io.mockk.impl.annotations.MockK
import io.mockk.spyk
import io.mockk.verify
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
import org.mockito.MockitoAnnotations

class FactsViewModelTest : BaseViewModelTest() {
    @get:Rule
    var rule: TestRule = InstantTaskExecutorRule()

    @MockK
    private lateinit var storage: FactsRepository

    private val viewModel by lazy {
        spyk(
            FactsViewModel(
                storage = storage
            )
        )
    }

    @Before
    fun prepare() {
        MockitoAnnotations.initMocks(this)
    }

    @Test
    fun `GIVEN a list WHEN call for facts THEN assrte fact list`() = runBlocking {
        // Given
        every {
            storage.facts
        } returns FAKE_FLOW_FACT_LIST

        // when
        viewModel.requestCuriousities()

        // Then
        assertEquals(FAKE_FACT_LIST, viewModel.facts.value)
    }

    companion object {
        private val FAKE_FACT_LIST: List<Fact> = listOf(
            Fact(
                id = "5a026092134ec2001f032f95",
                updatedDate = APIDateParser().parse("2020-08-23T20:20:01.611Z"),
                content = "Compared to other felines, domestic cats have narrowly spaced canine teeth, adapted to their preferred prey of small rodents."
            ),
            Fact(
                id = "591f98783b90f7150a19c1cf",
                updatedDate = APIDateParser().parse("2020-08-23T20:20:01.611Z"),
                content = "Contrary to popular belief, the cat is a social animal. A pet cat will respond and answer to speech, and seems to enjoy human companionship."
            ),
            Fact(
                id = "591f9890d369931519ce3572",
                updatedDate = APIDateParser().parse("2020-08-23T20:20:01.611Z"),
                content = "The leopard is the most widespread of all big cats."
            )
        )

        private val FAKE_FLOW_FACT_LIST: Flow<List<Fact>> = flowOf(
            FAKE_FACT_LIST
        )
    }

}