package com.learning.catz.base

import org.koin.core.context.startKoin
import org.koin.core.module.Module
import org.koin.dsl.module

open class BaseTest {

    protected fun startKoinForTests(
        vararg modules: Module,
        overrideBlock: Module.() -> Unit = {}
    ) {
        val modulesToLoad =
            modules
                .toMutableList()
                .apply { module(override = true) { overrideBlock() }.let(::add) }
                .toList()

        startKoin {
            modules(modulesToLoad)
        }
    }
}