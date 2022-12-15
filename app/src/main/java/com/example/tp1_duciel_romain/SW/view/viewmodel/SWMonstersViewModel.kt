package com.example.tp1_duciel_romain.SW.view.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.map
import androidx.lifecycle.viewModelScope
import com.example.tp1_duciel_romain.SW.domain.usecase.DeleteAllSWMonstersUseCase
import com.example.tp1_duciel_romain.SW.domain.usecase.FetchNewMonsterSWUseCase
import com.example.tp1_duciel_romain.SW.domain.usecase.GetSWMonstersUseCase
import com.example.tp1_duciel_romain.SW.view.mapper.fromDomainToUi
import com.example.tp1_duciel_romain.SW.view.model.ObjectForUi
import com.example.tp1_duciel_romain.SW.view.model.SWMonstersUi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlin.random.Random

class SWMonstersViewModel : ViewModel() {
    private val getSWMonstersUseCase: GetSWMonstersUseCase by lazy { GetSWMonstersUseCase() }
    private val fetchNewMonsterSWUseCase: FetchNewMonsterSWUseCase by lazy { FetchNewMonsterSWUseCase() }
    private val deleteAllSWMonstersUseCase: DeleteAllSWMonstersUseCase by lazy { DeleteAllSWMonstersUseCase() }

    var swMonstersLiveData: LiveData<List<ObjectForUi>> =
        getSWMonstersUseCase.selectAll().map {
            it.fromDomainToUi()
        }

    fun fetchNewMonster(){
        viewModelScope.launch(Dispatchers.IO){
            fetchNewMonsterSWUseCase.fetchData()
        }
    }

    fun deleteAll(){
        viewModelScope.launch(Dispatchers.IO){
            deleteAllSWMonstersUseCase.deleteAll()
        }
    }
}