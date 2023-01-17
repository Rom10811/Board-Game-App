package com.java.projet_android_restoy_duciel.Boardgame.view.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.map
import androidx.lifecycle.viewModelScope
import com.java.projet_android_restoy_duciel.Boardgame.domain.usecase.DeleteAllBoardgamesUseCase
import com.java.projet_android_restoy_duciel.Boardgame.domain.usecase.DeleteOneBoardgameUseCase
import com.java.projet_android_restoy_duciel.Boardgame.domain.usecase.InsertNewBoardgameUseCase
import com.java.projet_android_restoy_duciel.Boardgame.domain.usecase.GetBoardgamesUseCase
import com.java.projet_android_restoy_duciel.Boardgame.view.mapper.fromDomainToUi
import com.java.projet_android_restoy_duciel.Boardgame.view.model.ObjectForUi
import com.java.projet_android_restoy_duciel.architecture.RetrofitBuilder
import fr.upjv.ccm.tp1.model.Boardgame
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class BoardgameViewModel : ViewModel() {
    private val getBoardgamesUseCase: GetBoardgamesUseCase by lazy { GetBoardgamesUseCase() }
    private val deleteAllSWMonstersUseCase: DeleteAllBoardgamesUseCase by lazy { DeleteAllBoardgamesUseCase() }
    private val deleteOneBoardgameUseCase: DeleteOneBoardgameUseCase by lazy { DeleteOneBoardgameUseCase() }

    var boardgameLiveData: LiveData<List<ObjectForUi>> =
        getBoardgamesUseCase.selectAll().map {
            it.fromDomainToUi()
        }

    fun deleteOneBoardgame(name: String){
        viewModelScope.launch(Dispatchers.IO){
            deleteOneBoardgameUseCase.deleteOneBoardgame(name = name)
        }
    }

    fun deleteAll(){
        viewModelScope.launch(Dispatchers.IO){
            deleteAllSWMonstersUseCase.deleteAll()
        }
    }
}