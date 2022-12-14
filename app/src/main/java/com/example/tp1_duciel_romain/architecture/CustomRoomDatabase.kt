package com.example.tp1_duciel_romain.architecture

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.tp1_duciel_romain.dao.NBATeamDao
import com.example.tp1_duciel_romain.model.LocalDataSourceSample

@Database(
    entities = [
        LocalDataSourceSample::class
    ],
    version = 1,
    exportSchema = false
)
abstract class CustomRoomDatabase : RoomDatabase() {
    abstract fun mNBATeamDao(): NBATeamDao
}

