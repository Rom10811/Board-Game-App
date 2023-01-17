package com.java.projet_android_restoy_duciel.Boardgame.view.viewmodel

import android.util.Log
import androidx.lifecycle.*
import com.java.projet_android_restoy_duciel.Boardgame.data.mapper.toRoom
import com.java.projet_android_restoy_duciel.Boardgame.domain.usecase.GetBoardgamesUseCase
import com.java.projet_android_restoy_duciel.Boardgame.domain.usecase.InsertNewBoardgameUseCase
import com.java.projet_android_restoy_duciel.Boardgame.view.mapper.fromDomainToUi
import com.java.projet_android_restoy_duciel.Boardgame.view.mapper.toUi
import com.java.projet_android_restoy_duciel.Boardgame.view.model.BoardgameUI
import com.java.projet_android_restoy_duciel.Boardgame.view.model.ObjectForUi
import com.java.projet_android_restoy_duciel.architecture.RetrofitBuilder
import fr.upjv.ccm.tp1.model.BoardgameRoom
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SearchBoardgameViewModel : ViewModel() {

    private val getBoardgamesUseCase: GetBoardgamesUseCase by lazy { GetBoardgamesUseCase() }
    private val insertNewBoardgameUseCase: InsertNewBoardgameUseCase by lazy { InsertNewBoardgameUseCase() }
    private val _searchBoardgameList = MutableLiveData<List<ObjectForUi>>()
    val searchBoardgameList: LiveData<List<ObjectForUi>> get() = _searchBoardgameList

    var boardgameLiveData: LiveData<List<ObjectForUi>> =
        getBoardgamesUseCase.selectAll().map {
            it.fromDomainToUi()
        }


    fun fetchData(text: String) {
        viewModelScope.launch(Dispatchers.IO){

            val emptyBoardGameList: MutableList<BoardgameUI> = arrayListOf()


            RetrofitBuilder.getBoardgameQuote().getBoardgamesByName(name=text).games.forEach {
                Log.i("TEST", "Categ" + it.name)
                emptyBoardGameList.add(it.toUi())
            }

            _searchBoardgameList.postValue(emptyBoardGameList)

        }
    }


    fun insertBoardGame(boardgame: BoardgameRoom) {
        viewModelScope.launch(Dispatchers.IO) {
            insertNewBoardgameUseCase.insertBoardgame(boardgame = boardgame)
        }
    }

}