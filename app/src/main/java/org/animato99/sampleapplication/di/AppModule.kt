package org.animato99.sampleapplication.di

import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule
import com.fasterxml.jackson.module.kotlin.KotlinModule
import okhttp3.OkHttpClient
import org.animato99.sampleapplication.data.source.MetroDataSource
import org.animato99.sampleapplication.data.source.MetroRepository
import org.animato99.sampleapplication.data.source.remote.MetroDataSourceRemote
import org.koin.dsl.module.module

val appModule = module {
    single {
        ObjectMapper()
                .registerModule(KotlinModule())
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
                .registerModule(JavaTimeModule())
    }
    single { OkHttpClient() }
    single<MetroDataSource> { MetroDataSourceRemote(get()) }
    single { MetroRepository(get()) }
}