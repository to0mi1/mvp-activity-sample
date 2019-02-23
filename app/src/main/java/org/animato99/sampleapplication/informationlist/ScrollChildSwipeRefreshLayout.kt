package org.animato99.sampleapplication.informationlist

import android.content.Context
import android.support.v4.view.ViewCompat
import android.support.v4.widget.SwipeRefreshLayout
import android.util.AttributeSet
import android.view.View

open class ScrollChildSwipeRefreshLayout : SwipeRefreshLayout {

    private var scrollUpChild: View? = null

    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet) : super(context, attrs)

    override fun canChildScrollUp(): Boolean {
        if (scrollUpChild != null) {
            return ViewCompat.canScrollVertically(scrollUpChild, -1)
        }
        return super.canChildScrollUp()
    }

    fun setScrollUpChild(view: View) {
        scrollUpChild = view
    }
}