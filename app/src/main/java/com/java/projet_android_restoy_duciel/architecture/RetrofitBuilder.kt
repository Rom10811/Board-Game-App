package com.java.projet_android_restoy_duciel.architecture

import com.google.gson.GsonBuilder
import com.java.projet_android_restoy_duciel.Boardgame.data.remote.BoardgameEndpoint
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitBuilder {

    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("https://api.boardgameatlas.com/api/")
        .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
        .build()


    fun getBoardgameQuote(): BoardgameEndpoint = retrofit.create(BoardgameEndpoint::class.java)
}