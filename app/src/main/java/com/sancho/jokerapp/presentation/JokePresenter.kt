package com.sancho.jokerapp.presentation

import com.sancho.jokerapp.data.JokeCallback
import com.sancho.jokerapp.data.JokeRemoteDataSource
import com.sancho.jokerapp.model.Joke
import com.sancho.jokerapp.view.JokeFragment

class JokePresenter(
    private val view: JokeFragment,
    private val dataSource: JokeRemoteDataSource = JokeRemoteDataSource()
) : JokeCallback {

    fun findRandom(categoryName: String) {
        view.showProgress()
        dataSource.findBy(categoryName, this)
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