package com.java.projet_android_restoy_duciel.architecture

import android.app.Application
import androidx.room.Room

class CustomApplication : Application() {

    companion object {
        lateinit var instance: CustomApplication
    }

    val mBoardGameDatabase : CustomRoomDatabase by lazy {
        Room.databaseBuilder(
            applicationContext,
            CustomRoomDatabase::class.java,
            "BoardGameDatabase"
        ).fallbackToDestructiveMigration().build()
    }


    override fun onCreate() {
        super.onCreate()
        instance = this
    }
}