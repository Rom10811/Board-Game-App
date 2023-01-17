package com.java.projet_android_restoy_duciel.Boardgame.domain.usecase

import androidx.lifecycle.LiveData
import com.java.projet_android_restoy_duciel.Boardgame.domain.model.BoardgameDomain
import com.java.projet_android_restoy_duciel.Boardgame.domain.repository.BoardgameRepository
import fr.upjv.ccm.tp1.repository.BoardgameRepositoryImpl

class GetBoardgamesUseCase {
    private val boardgameRepository: BoardgameRepository by lazy { BoardgameRepositoryImpl() }

    fun selectAll():LiveData<List<BoardgameDomain>>{
        return boardgameRepository.selectAllBoardgames()
    }
}