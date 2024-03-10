package com.sancho.jokerapp.data

import com.sancho.jokerapp.model.Joke

interface JokeCallback {
    fun onSuccess(response: Joke)

    fun onError(response: String)

    fun onComplete()
}