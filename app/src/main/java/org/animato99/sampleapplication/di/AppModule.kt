package org.animato99.sampleapplication.di

import com.fasterxml.jackson.databind.ObjectMapper
import okhttp3.OkHttpClient
import org.animato99.sampleapplication.data.source.MetroDataSource
import org.animato99.sampleapplication.data.source.MetroRepositoryImpl
import org.animato99.sampleapplication.data.source.remote.MetroDataSourceRemote
import org.koin.dsl.module.module

val appModule = module {
    single { ObjectMapper() }
    single { OkHttpClient() }
    single<MetroDataSource> { MetroDataSourceRemote(get()) }
    single { MetroRepositoryImpl(get()) }
}