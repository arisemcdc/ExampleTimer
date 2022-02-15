package com.example.exampletimer

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlin.coroutines.CoroutineContext

class MainPresenter (private val model: MainModel): CoroutineScope {

    private var view: MainView? = null
    var text : String? = null
    override val coroutineContext: CoroutineContext
        get() = Dispatchers.IO


    fun bind(view: MainView) {
        this.view = view
    }

    fun unbind() {
        this.view = null
    }

    fun start() {
        launch {
            model.data(13500)
            withContext(Dispatchers.Main){
                view?.showTimer()
            }
        }

    }
}