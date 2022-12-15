package com.example.tp1_duciel_romain.SW.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.map
import com.example.tp1_duciel_romain.SW.data.mapper.fromRoomToDomain
import com.example.tp1_duciel_romain.SW.data.mapper.toRoom
import com.example.tp1_duciel_romain.SW.data.model.SWMonstersRoom
import com.example.tp1_duciel_romain.SW.domain.model.SWMonstersDomain
import com.example.tp1_duciel_romain.SW.domain.repository.SWMonstersRepository
import com.example.tp1_duciel_romain.architecture.CustomApplication
import com.example.tp1_duciel_romain.architecture.RetrofitBuilder
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class SWMonstersRepositoryImpl: SWMonstersRepository {
    private val mSWMonstersDao = CustomApplication.instance.mApplicationDatabase.mSWMonstersDAO()

    override fun selectAll(): LiveData<List<SWMonstersDomain>> {
        return mSWMonstersDao.selectAll().map {
            it.fromRoomToDomain()
        }
    }

    override suspend fun deleteAll() = withContext(Dispatchers.IO){
        mSWMonstersDao.deleteAll()
    }

    override suspend fun fetchData(random: Int) {
        insertSWMonsters(RetrofitBuilder.getSWMonster().getRandomMonster(random).toRoom())
    }

    private fun insertSWMonsters(swDataMonster: SWMonstersRoom) {
        mSWMonstersDao.insert(swDataMonster)
    }

}