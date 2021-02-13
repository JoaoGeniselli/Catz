package com.learning.catz.di

import com.learning.catz.network.CatzAPI
import com.learning.catz.network.RetrofitClient
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

const val KOIN_RETROFIT = "retrofit"
const val KOIN_WEB_API_URL = "webApiUrl"

val networkModule = module {

    // Base Network
    single(named(KOIN_RETROFIT)) {
        Retrofit
            .Builder()
            .baseUrl(get<String>(named(KOIN_WEB_API_URL)))
            .addConverterFactory(get<GsonConverterFactory>())
            .build()
    }

    single(named(KOIN_WEB_API_URL)) {
        "https://cat-fact.herokuapp.com/"
    }

    single {
        GsonConverterFactory.create()
    }


    // Request
    single {
        RetrofitClient.createService(get(named(KOIN_RETROFIT)), CatzAPI::class.java)
    }
}