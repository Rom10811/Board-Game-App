package com.java.projet_android_restoy_duciel.architecture

import androidx.room.Database
import androidx.room.RoomDatabase
import com.java.projet_android_restoy_duciel.SW.data.local.SWMonstersDao
import com.java.projet_android_restoy_duciel.SW.data.model.SWMonstersRoom

@Database(
    entities = [
        SWMonstersRoom::class
    ],
    version = 2,
    exportSchema = false
)

abstract class CustomRoomDatabase : RoomDatabase() {
    abstract fun mSWMonstersDAO(): SWMonstersDao
}

