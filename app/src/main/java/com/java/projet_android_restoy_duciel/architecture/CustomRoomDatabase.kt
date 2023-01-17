package com.java.projet_android_restoy_duciel.architecture

import androidx.room.Database
import androidx.room.RoomDatabase
import com.java.projet_android_restoy_duciel.Boardgame.data.local.BoardgameDao
import fr.upjv.ccm.tp1.model.BoardgameRoom

@Database(
    entities = [
        BoardgameRoom::class
    ],
    version = 3,
    exportSchema = false
)
abstract class CustomRoomDatabase : RoomDatabase() {

    abstract fun BoardgameDao(): BoardgameDao
}

