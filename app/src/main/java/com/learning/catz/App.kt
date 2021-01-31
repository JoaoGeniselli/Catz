package com.learning.catz

import android.app.Application
import android.content.Context
import com.learning.catz.di.commonsModule
import com.learning.catz.di.factsModule
import com.learning.catz.di.networkModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        context = applicationContext
        startKoin {
            androidContext(this@App)
            modules(
                listOf(
                    factsModule,
                    commonsModule,
                    networkModule
                )
            )
        }
    }

    companion object {
        lateinit var context: Context
    }
}

