package com.example.tp1_duciel_romain.SW.domain.repository

import androidx.lifecycle.LiveData
import com.example.tp1_duciel_romain.SW.domain.model.SWMonstersDomain

interface SWMonstersRepository {

    fun selectAll(): LiveData<List<SWMonstersDomain>>

    suspend fun deleteAll()

    suspend fun fetchData(random: Int)
}