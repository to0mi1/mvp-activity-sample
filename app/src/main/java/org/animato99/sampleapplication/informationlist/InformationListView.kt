package org.animato99.sampleapplication.informationlist

import android.content.Context
import android.support.design.widget.Snackbar
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.AttributeSet
import android.view.View
import org.animato99.sampleapplication.R
import org.animato99.sampleapplication.data.TrainInformation
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v4.content.ContextCompat
import android.widget.Toast
import org.koin.standalone.KoinComponent
import org.koin.standalone.inject
import java.util.*


class InformationListView : ScrollChildSwipeRefreshLayout, InformationListContract.View {

    init {
        init()
    }
    override lateinit var presenter: InformationListContract.Presenter

    private lateinit var recyclerView: RecyclerView

    private lateinit var informationListAdapter: InformationListAdapter
    constructor(context: Context, attrs: AttributeSet) : super(context, attrs)

    constructor(context: Context) : super(context)
    override fun showInformation(info: List<TrainInformation>) {
        informationListAdapter.replaceData(info)
    }

    private fun init() {
        View.inflate(context, R.layout.information_list_content, this)
        informationListAdapter = InformationListAdapter(listOf())
        recyclerView = findViewById(R.id.informationRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = informationListAdapter

        // Set up progress indicator
        val swipeRefreshLayout = this
        swipeRefreshLayout.setColorSchemeColors(
                ContextCompat.getColor(context, R.color.colorPrimary),
                ContextCompat.getColor(context, R.color.colorAccent),
                ContextCompat.getColor(context, R.color.colorPrimaryDark)
        )
        // Set the scrolling view in the custom SwipeRefreshLayout.
        swipeRefreshLayout.setScrollUpChild(recyclerView)

        swipeRefreshLayout.setOnRefreshListener { presenter.loadInformation() }
    }


    override fun showToast(message: String) {
//        Toast.makeText(context, "OK", Toast.LENGTH_LONG).show()
        Snackbar.make(this, message, Snackbar.LENGTH_SHORT).show()
    }

    override fun setLoadingIndicator(active: Boolean) {
        val srl = this
        srl.post { srl.isRefreshing = active }
    }


}
