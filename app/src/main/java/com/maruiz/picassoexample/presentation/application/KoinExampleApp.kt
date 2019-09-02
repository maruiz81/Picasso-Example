package com.maruiz.picassoexample.presentation.application

import android.app.Application
import com.maruiz.picassoexample.presentation.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class KoinExampleApp : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@KoinExampleApp)
            // modules
            modules(appModule)

            fileProperties()
        }
    }
}