package com.java.projet_android_restoy_duciel.SW.domain.usecase

import androidx.lifecycle.LiveData
import com.java.projet_android_restoy_duciel.SW.data.repository.SWMonstersRepositoryImpl
import com.java.projet_android_restoy_duciel.SW.domain.model.SWMonstersDomain
import com.java.projet_android_restoy_duciel.SW.domain.repository.SWMonstersRepository

class GetSWMonstersUseCase {
    private val swMonstersRepository: SWMonstersRepository by lazy { SWMonstersRepositoryImpl() }

    fun selectAll():LiveData<List<SWMonstersDomain>>{
        return swMonstersRepository.selectAll()
    }
}