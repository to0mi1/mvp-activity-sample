package org.animato99.sampleapplication.di

import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.KotlinModule
import okhttp3.OkHttpClient
import org.animato99.sampleapplication.data.source.MetroDataSource
import org.animato99.sampleapplication.data.source.MetroRepository
import org.animato99.sampleapplication.data.source.remote.MetroDataSourceRemote
import org.animato99.sampleapplication.informationlist.InformationListPresenter
import org.animato99.sampleapplication.informationlist.InformationListContract
import org.koin.dsl.module.module

val appModule = module {
    single {
        ObjectMapper()
                .registerModule(KotlinModule())
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
    }
    single { OkHttpClient() }
    single<MetroDataSource> { MetroDataSourceRemote(get()) }
    factory { MetroRepository(get()) }
    factory<InformationListContract.Presenter> { InformationListPresenter(get()) }
}