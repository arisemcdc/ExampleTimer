package com.example.exampletimer

class MainPresenter (private val model: MainModel) {

    fun start() {
        model.data(13500)
    }
}