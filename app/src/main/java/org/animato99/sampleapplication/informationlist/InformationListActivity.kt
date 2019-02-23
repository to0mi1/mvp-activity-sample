package org.animato99.sampleapplication.informationlist

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import org.animato99.sampleapplication.R

import kotlinx.android.synthetic.main.information_list_activity.*
import org.koin.android.ext.android.inject

class InformationListActivity : AppCompatActivity() {

    private val presenter: InformationListContract.Presenter by inject()

    private lateinit var informationListView : InformationListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.information_list_activity)
        setSupportActionBar(toolbar)

        informationListView = findViewById(R.id.informationListView)
        presenter.takeView(informationListView)
        informationListView.presenter = presenter
    }

    override fun onResume() {
        super.onResume()
        presenter.loadInformation()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.dropView()
    }
}
