package com.example.tp1_duciel_romain.SW.data.remote

import com.example.tp1_duciel_romain.SW.data.model.SWMonstersRetrofit
import retrofit2.http.GET
import retrofit2.http.Path

interface SWMonstersEndpoint {
    @GET("monsters/{random}/")
    suspend fun getRandomMonster(@Path("random") random: Int?,): SWMonstersRetrofit
}