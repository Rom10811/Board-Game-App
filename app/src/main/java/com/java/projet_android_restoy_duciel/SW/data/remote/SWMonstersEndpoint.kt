package com.java.projet_android_restoy_duciel.SW.data.remote

import com.java.projet_android_restoy_duciel.SW.data.model.SWMonstersRetrofit
import retrofit2.http.GET
import retrofit2.http.Path

interface SWMonstersEndpoint {
    @GET("monsters/{random}/")
    suspend fun getRandomMonster(@Path("random") random: Int?,): SWMonstersRetrofit
}