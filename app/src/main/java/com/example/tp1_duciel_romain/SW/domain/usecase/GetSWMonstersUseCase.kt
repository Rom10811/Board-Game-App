package com.example.tp1_duciel_romain.SW.domain.usecase

import androidx.lifecycle.LiveData
import com.example.tp1_duciel_romain.SW.data.repository.SWMonstersRepositoryImpl
import com.example.tp1_duciel_romain.SW.domain.model.SWMonstersDomain
import com.example.tp1_duciel_romain.SW.domain.repository.SWMonstersRepository

class GetSWMonstersUseCase {
    private val swMonstersRepository: SWMonstersRepository by lazy { SWMonstersRepositoryImpl() }

    fun selectAll():LiveData<List<SWMonstersDomain>>{
        return swMonstersRepository.selectAll()
    }
}