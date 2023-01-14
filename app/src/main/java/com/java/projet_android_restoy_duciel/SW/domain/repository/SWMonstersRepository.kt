package com.java.projet_android_restoy_duciel.SW.domain.repository

import androidx.lifecycle.LiveData
import com.java.projet_android_restoy_duciel.SW.domain.model.SWMonstersDomain

interface SWMonstersRepository {

    fun selectAll(): LiveData<List<SWMonstersDomain>>

    suspend fun deleteAll()

    suspend fun fetchData(random: Int)
}