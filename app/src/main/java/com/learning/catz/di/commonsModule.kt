package com.learning.catz.di

import com.learning.catz.commons.APIDateParser
import com.learning.catz.commons.DateFormatter
import org.koin.dsl.module

val commonsModule = module {
    single {
        APIDateParser()
    }

    single {
        DateFormatter()
    }
}