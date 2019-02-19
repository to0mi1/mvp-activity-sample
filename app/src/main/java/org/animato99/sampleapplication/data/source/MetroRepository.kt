package org.animato99.sampleapplication.data.source

import org.animato99.sampleapplication.data.source.MetroDataSource.GetTrainInformationCallback

interface MetroRepository : MetroDataSource {

    override fun getTrainInformation(callback: GetTrainInformationCallback) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}