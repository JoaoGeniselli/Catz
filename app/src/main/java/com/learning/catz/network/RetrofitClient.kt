package com.learning.catz.network

import retrofit2.Retrofit

object RetrofitClient {
    fun <T> createService(retrofit: Retrofit, javaClass: Class<T>): T {
        return retrofit.create(javaClass)
    }
}