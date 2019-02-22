package org.animato99.sampleapplication.data.source

import org.animato99.sampleapplication.data.TrainInformation

interface MetroDataSource {

    /**
     * 運行情報の API のレスポンス結果を受け取る.
     */
    interface GetTrainInformationCallback {
        fun onResponse(info: List<TrainInformation>, statusCode: Int)
        fun onFailure()
    }

    fun getTrainInformation(callback: GetTrainInformationCallback)
}