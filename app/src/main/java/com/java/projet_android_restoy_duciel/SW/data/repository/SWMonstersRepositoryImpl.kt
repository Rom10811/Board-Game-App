package com.java.projet_android_restoy_duciel.SW.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.map
import com.java.projet_android_restoy_duciel.SW.data.mapper.fromRoomToDomain
import com.java.projet_android_restoy_duciel.SW.data.mapper.toRoom
import com.java.projet_android_restoy_duciel.SW.data.model.SWMonstersRoom
import com.java.projet_android_restoy_duciel.SW.domain.model.SWMonstersDomain
import com.java.projet_android_restoy_duciel.SW.domain.repository.SWMonstersRepository
import com.java.projet_android_restoy_duciel.architecture.CustomApplication
import com.java.projet_android_restoy_duciel.architecture.RetrofitBuilder
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