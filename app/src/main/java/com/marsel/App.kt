package com.marsel

import android.app.Application
import com.marsel.di.apiModule
import com.marsel.di.repositoryModule
import com.marsel.di.retrofitModule
import com.marsel.di.useCaseModule
import com.marsel.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin
import org.koin.core.logger.Level

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(Level.DEBUG)
            androidContext(this@App)
            modules(listOf(retrofitModule, apiModule, repositoryModule, useCaseModule, viewModelModule))
            printLogger()
        }
    }
}