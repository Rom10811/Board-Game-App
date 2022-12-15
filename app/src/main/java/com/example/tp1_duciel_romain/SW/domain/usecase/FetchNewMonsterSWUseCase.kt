package com.example.tp1_duciel_romain.SW.domain.usecase

import com.example.tp1_duciel_romain.SW.data.repository.SWMonstersRepositoryImpl
import com.example.tp1_duciel_romain.SW.domain.repository.SWMonstersRepository
import kotlin.random.Random

class FetchNewMonsterSWUseCase {
    private val swMonstersRepository: SWMonstersRepository by lazy { SWMonstersRepositoryImpl() }

    suspend fun fetchData(){
        val random = Random.nextInt(0,2079)
        swMonstersRepository.fetchData(random)
    }
}