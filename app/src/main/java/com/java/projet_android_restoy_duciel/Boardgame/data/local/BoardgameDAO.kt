package com.java.projet_android_restoy_duciel.Boardgame.data.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import fr.upjv.ccm.tp1.model.BoardgameRoom

@Dao
interface BoardgameDao {

    @Query("SELECT * FROM boardgame_object_table ORDER BY name ASC")
    fun selectAll(): LiveData<List<BoardgameRoom>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(boardgame: BoardgameRoom)

    @Query("DELETE FROM boardgame_object_table")
    fun deleteAll()

    @Query("DELETE FROM boardgame_object_table WHERE name= :name")
    fun deleteOne(name: String)
}
