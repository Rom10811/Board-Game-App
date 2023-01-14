package com.java.projet_android_restoy_duciel.SW.view.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.map
import androidx.lifecycle.viewModelScope
import com.java.projet_android_restoy_duciel.SW.domain.usecase.DeleteAllSWMonstersUseCase
import com.java.projet_android_restoy_duciel.SW.domain.usecase.FetchNewMonsterSWUseCase
import com.java.projet_android_restoy_duciel.SW.domain.usecase.GetSWMonstersUseCase
import com.java.projet_android_restoy_duciel.SW.view.mapper.fromDomainToUi
import com.java.projet_android_restoy_duciel.SW.view.model.ObjectForUi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

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