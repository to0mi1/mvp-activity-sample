package org.animato99.sampleapplication.data.source

import org.animato99.sampleapplication.data.source.MetroDataSource.GetTrainInformationCallback

class MetroRepository(private val metroDataSource: MetroDataSource) : MetroDataSource {

    override fun getTrainInformation(callback: GetTrainInformationCallback) {
        metroDataSource.getTrainInformation(callback)
    }
}