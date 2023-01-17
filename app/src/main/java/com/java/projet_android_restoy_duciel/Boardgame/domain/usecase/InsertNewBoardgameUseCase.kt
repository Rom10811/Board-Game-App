package com.java.projet_android_restoy_duciel.Boardgame.domain.usecase

import com.java.projet_android_restoy_duciel.Boardgame.domain.repository.BoardgameRepository
import fr.upjv.ccm.tp1.model.BoardgameRoom
import fr.upjv.ccm.tp1.repository.BoardgameRepositoryImpl

class InsertNewBoardgameUseCase {
    private val boardgameRepository: BoardgameRepository by lazy { BoardgameRepositoryImpl() }

    suspend fun insertBoardgame(boardgame: BoardgameRoom){
        boardgameRepository.insertBoardgame(boardgame)
    }
}