package com.learning.catz.di

import com.learning.catz.facts.FactDiffCallback
import com.learning.catz.facts.FactsAdapter
import com.learning.catz.facts.FactsRepository
import com.learning.catz.facts.FactsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val factsModule = module {
    viewModel {
        FactsViewModel(get())
    }

    single {
        FactsRepository(get(), get())
    }

    factory {
        FactsAdapter(get(), get())
    }

    factory {
        FactDiffCallback()
    }
}