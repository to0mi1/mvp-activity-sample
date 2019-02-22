package org.animato99.sampleapplication.data.source.remote

import org.animato99.sampleapplication.data.TrainInformation
import org.animato99.sampleapplication.data.source.MetroDataSource
import org.animato99.sampleapplication.di.appModule
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.koin.standalone.StandAloneContext
import org.koin.standalone.inject
import org.koin.test.AutoCloseKoinTest
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
class MetroDataSourceRemoteTest : AutoCloseKoinTest() {

    private val metroDataSourceRemote by inject<MetroDataSource>()

    @Before
    fun init() {
        StandAloneContext.startKoin(listOf(appModule))
    }

    @Test
    fun getTrainInformation_get() {
        metroDataSourceRemote.getTrainInformation(object : MetroDataSource.GetTrainInformationCallback {
            override fun onResponse(info: List<TrainInformation>, statusCode: Int) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onFailure() {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }
        })
    }
}