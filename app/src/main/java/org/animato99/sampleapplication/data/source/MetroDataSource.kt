package org.animato99.sampleapplication.data.source

interface MetroDataSource {

    /**
     * 運行情報の API のレスポンス結果を受け取る.
     */
    interface GetTrainInformationCallback {
        fun onResponse()
        fun onFailure()
    }

    fun getTrainInformation(callback: GetTrainInformationCallback)
}