package org.animato99.sampleapplication

interface BasePresenter<T> {
    fun takeView(view: T)

    fun dropView()
}