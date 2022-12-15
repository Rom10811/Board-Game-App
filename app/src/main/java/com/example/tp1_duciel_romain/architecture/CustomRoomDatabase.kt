package com.example.tp1_duciel_romain.architecture

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.tp1_duciel_romain.NBA.dao.NBATeamDao
import com.example.tp1_duciel_romain.NBA.model.LocalDataSourceSample
import com.example.tp1_duciel_romain.SW.data.local.SWMonstersDao
import com.example.tp1_duciel_romain.SW.data.model.SWMonstersRoom

@Database(
    entities = [
        LocalDataSourceSample::class,
        SWMonstersRoom::class
    ],
    version = 2,
    exportSchema = false
)

abstract class CustomRoomDatabase : RoomDatabase() {
    abstract fun mNBATeamDao(): NBATeamDao
    abstract fun mSWMonstersDAO(): SWMonstersDao
}

