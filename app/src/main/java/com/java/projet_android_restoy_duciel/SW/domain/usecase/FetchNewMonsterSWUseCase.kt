package com.java.projet_android_restoy_duciel.SW.domain.usecase

import com.java.projet_android_restoy_duciel.SW.data.repository.SWMonstersRepositoryImpl
import com.java.projet_android_restoy_duciel.SW.domain.repository.SWMonstersRepository
import kotlin.random.Random

class FetchNewMonsterSWUseCase {
    private val swMonstersRepository: SWMonstersRepository by lazy { SWMonstersRepositoryImpl() }

    suspend fun fetchData(){
        val random = Random.nextInt(0,2079)
        swMonstersRepository.fetchData(random)
    }
}