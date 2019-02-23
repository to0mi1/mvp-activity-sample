package org.animato99.sampleapplication.informationlist

import android.os.Handler
import android.widget.Toast
import org.animato99.sampleapplication.data.TrainInformation
import org.animato99.sampleapplication.data.source.MetroDataSource
import org.animato99.sampleapplication.data.source.MetroRepository

class InformationListPresenter(
        private val metroRepository: MetroRepository
) : InformationListContract.Presenter {

    private var informationListView: InformationListContract.View? = null

    override fun loadInformation() {

        informationListView!!.setLoadingIndicator(true)

        metroRepository.getTrainInformation(object : MetroDataSource.GetTrainInformationCallback {
            override fun onResponse(info: List<TrainInformation>, statusCode: Int) {
                informationListView!!.showToast("更新しました")
                if (!info.isEmpty()) {
                    informationListView!!.showInformation(info)
                }
                informationListView!!.setLoadingIndicator(false)
            }

            override fun onFailure() {
                informationListView!!.setLoadingIndicator(false)
                informationListView!!.showToast("更新に失敗しました")
            }

        })
    }

    override fun takeView(view: InformationListContract.View) {
        this.informationListView = view
        this.informationListView!!.presenter = this
    }

    override fun dropView() {
        this.informationListView = null
    }

}