package com.learning.catz.facts

import com.learning.catz.network.CatzAPI
import com.learning.catz.network.FactResponse
import com.learning.catz.commons.APIDateParser
import com.learning.catz.network.AnimalType
import com.learning.catz.network.RetrofitClient
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class FactsRepository {

    private val api: CatzAPI by lazy { RetrofitClient.catzAPI }
    private val apiDateParser = APIDateParser()

    val facts: Flow<List<Fact>> = flow {
        val response = api.fetchFacts(
            AnimalType.CAT.identifier,
            FACTS_AMOUNT
        )
        if (response.isSuccessful) {
            val validFacts = response.body()
                ?.filter { it.isValid() }
                ?.map { it.toFact() }
                ?: listOf()
            emit(validFacts)
        } else {
            error(response.errorBody().toString())
        }
    }

    private fun FactResponse.isValid(): Boolean = id.isNullOrEmpty().not() and
            content.isNullOrEmpty().not() and updatedDate.isNullOrEmpty().not()

    private fun FactResponse.toFact(): Fact =
        Fact(
            id = id.orEmpty(),
            content = content.orEmpty(),
            updatedDate = apiDateParser.parse(updatedDate)
        )

    companion object {
        private const val FACTS_AMOUNT = 10L
    }

}