package com.example.tp1_duciel_romain.architecture

import com.example.tp1_duciel_romain.SW.data.remote.SWMonstersEndpoint
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitBuilder {
    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("https://swarfarm.com/api/v2/")
        .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
        .build()

    fun getSWMonster(): SWMonstersEndpoint = retrofit.create(SWMonstersEndpoint::class.java)
}
