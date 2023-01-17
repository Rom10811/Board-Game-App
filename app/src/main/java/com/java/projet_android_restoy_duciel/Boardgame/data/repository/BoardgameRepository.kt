package fr.upjv.ccm.tp1.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.map
import com.java.projet_android_restoy_duciel.Boardgame.data.mapper.fromRoomToDomain
import com.java.projet_android_restoy_duciel.Boardgame.domain.model.BoardgameDomain
import com.java.projet_android_restoy_duciel.Boardgame.domain.repository.BoardgameRepository
import com.java.projet_android_restoy_duciel.architecture.CustomApplication
import fr.upjv.ccm.tp1.model.BoardgameRoom

class BoardgameRepositoryImpl: BoardgameRepository {
    private val mSWMonstersDao = CustomApplication.instance.mBoardGameDatabase.BoardgameDao()

    private val mBoardGameDatabase =
        CustomApplication.instance.mBoardGameDatabase.BoardgameDao()

    override fun selectAllBoardgames(): LiveData<List<BoardgameDomain>> {
        return mBoardGameDatabase.selectAll().map { list ->
            list.fromRoomToDomain()
        }
    }

    override suspend fun insertBoardgame(boardgame: BoardgameRoom) {
        mBoardGameDatabase.insert(boardgame)
    }

    override suspend fun deleteOneBoardgame(name: String) {
        mBoardGameDatabase.deleteOne(name)
    }

    override suspend fun deleteAllBoardgame() {
        mBoardGameDatabase.deleteAll()
    }
}