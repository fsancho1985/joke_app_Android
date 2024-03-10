package com.sancho.jokerapp.presentation

import com.sancho.jokerapp.data.JokeCallback
import com.sancho.jokerapp.data.JokeDayRemoteDataSource
import com.sancho.jokerapp.model.Joke
import com.sancho.jokerapp.view.JokeDayFragment

class JokeDayPresenter(
    private val view: JokeDayFragment,
    private val dataSource: JokeDayRemoteDataSource = JokeDayRemoteDataSource()
) : JokeCallback {

    fun findRandom() {
        view.showProgress()
        dataSource.findRandom(this)
    }

    override fun onSuccess(response: Joke) {
        view.showJoke(response)
    }

    override fun onError(response: String) {
        view.showFailure(response)
    }

    override fun onComplete() {
        view.hideProgress()
    }


}