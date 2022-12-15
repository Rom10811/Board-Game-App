package com.example.tp1_duciel_romain.SW.domain.usecase

import com.example.tp1_duciel_romain.SW.data.repository.SWMonstersRepositoryImpl
import com.example.tp1_duciel_romain.SW.domain.repository.SWMonstersRepository

class DeleteAllSWMonstersUseCase {

    private val swMonstersRepository: SWMonstersRepository by lazy { SWMonstersRepositoryImpl() }

    suspend fun deleteAll(){
        swMonstersRepository.deleteAll()
    }
}