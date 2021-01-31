package com.learning.catz

import android.app.Application
import android.content.Context
import com.learning.catz.di.factsModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()
         context = applicationContext
        startKoin {
            androidContext(this@App)
            modules(listOf(
                factsModule
            ))
        }
    }

    companion object {
        lateinit var context: Context
    }
}

