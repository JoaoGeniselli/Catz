package com.learning.catz.network

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface CatzAPI {
    @GET("/facts/random")
    suspend fun fetchFacts(
        @Query("animal_type") animalType: String,
        @Query("amount") amount: Long
    ): Response<List<FactResponse>>
}