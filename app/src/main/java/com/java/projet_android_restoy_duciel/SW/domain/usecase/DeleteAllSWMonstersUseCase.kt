package com.java.projet_android_restoy_duciel.SW.domain.usecase

import com.java.projet_android_restoy_duciel.SW.data.repository.SWMonstersRepositoryImpl
import com.java.projet_android_restoy_duciel.SW.domain.repository.SWMonstersRepository

class DeleteAllSWMonstersUseCase {

    private val swMonstersRepository: SWMonstersRepository by lazy { SWMonstersRepositoryImpl() }

    suspend fun deleteAll(){
        swMonstersRepository.deleteAll()
    }
}