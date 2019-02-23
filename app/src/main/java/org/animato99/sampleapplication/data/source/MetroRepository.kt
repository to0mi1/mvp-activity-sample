package org.animato99.sampleapplication.data.source

import org.animato99.sampleapplication.data.TrainInformation
import org.animato99.sampleapplication.data.source.MetroDataSource.GetTrainInformationCallback

class MetroRepository(private val metroDataSource: MetroDataSource) : MetroDataSource {

    private val cache = mutableListOf<TrainInformation>()

    override fun getTrainInformation(callback: GetTrainInformationCallback) {

        metroDataSource.getTrainInformation(object: GetTrainInformationCallback{
            override fun onResponse(info: List<TrainInformation>, statusCode: Int) {
                cache.removeAll(cache)
                info.forEach { t: TrainInformation? -> cache.add(t!!) }
                callback.onResponse(cache, statusCode)
            }

            override fun onFailure() {
                callback.onFailure()
            }

        })
    }
}