package com.learning.catz.base

import android.content.Context
import androidx.annotation.CallSuper
import com.learning.catz.di.factsModule
import io.mockk.MockKAnnotations
import io.mockk.impl.annotations.MockK
import org.junit.Before
import org.koin.core.context.GlobalContext
import org.koin.core.module.Module


open class BaseViewModelTest : BaseTest(){

    @MockK
    lateinit var mockContext: Context

    open val koinModuleOverride: Module.() -> Unit = {}

    @Before
    @CallSuper
    fun onSetupKoin() {
        MockKAnnotations.init(this, relaxUnitFun = true)

        @Suppress("ControlFlowWithEmptyBody")
        while (GlobalContext.getOrNull() != null);

        startKoinForTests(factsModule) {
            single { mockContext }
            koinModuleOverride()
        }
    }
}