package org.animato99.sampleapplication

import android.app.Application
import org.animato99.sampleapplication.di.appModule
import org.koin.android.ext.android.startKoin

class SampleApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin(this, listOf(appModule))
    }
}