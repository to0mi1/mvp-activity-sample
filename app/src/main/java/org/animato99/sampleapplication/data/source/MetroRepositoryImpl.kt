package org.animato99.sampleapplication.data.source

import org.animato99.sampleapplication.data.TrainInformation

class MetroRepositoryImpl(
        private val metroDataSource: MetroDataSource
) : MetroRepository {

    private val trainInformationChache: List<TrainInformation> = listOf()

    override fun getTrainInformation(callback: MetroDataSource.GetTrainInformationCallback) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}