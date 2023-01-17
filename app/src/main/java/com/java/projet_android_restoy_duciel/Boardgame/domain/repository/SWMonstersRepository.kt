package com.java.projet_android_restoy_duciel.Boardgame.domain.repository

import androidx.lifecycle.LiveData
import com.java.projet_android_restoy_duciel.Boardgame.domain.model.BoardgameDomain
import fr.upjv.ccm.tp1.model.Boardgame
import fr.upjv.ccm.tp1.model.BoardgameRoom

interface BoardgameRepository {

    fun selectAllBoardgames(): LiveData<List<BoardgameDomain>>
    suspend fun deleteAllBoardgame()
    suspend fun deleteOneBoardgame(name: String)
    suspend fun insertBoardgame(boardgame: BoardgameRoom)

}