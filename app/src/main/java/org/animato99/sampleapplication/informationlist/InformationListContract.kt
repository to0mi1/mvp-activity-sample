package org.animato99.sampleapplication.informationlist

import org.animato99.sampleapplication.BasePresenter
import org.animato99.sampleapplication.BaseView
import org.animato99.sampleapplication.data.TrainInformation

interface InformationListContract {
    interface View : BaseView<Presenter> {

        fun showInformation(info: List<TrainInformation>)

        fun showToast(message: String)

        fun setLoadingIndicator(active: Boolean)

    }

    interface Presenter : BasePresenter<View> {
        fun loadInformation()
    }
}

