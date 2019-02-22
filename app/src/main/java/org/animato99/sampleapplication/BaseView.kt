package org.animato99.sampleapplication

interface BaseView<T>() {
    fun setPresenter(presenter: T)
}