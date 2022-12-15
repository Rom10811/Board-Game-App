package com.example.tp1_duciel_romain.NBA.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.tp1_duciel_romain.NBA.model.LocalDataSourceSample

@Dao
interface NBATeamDao {
    @Query("SELECT * FROM nba_team_object_table ORDER BY rank ASC")
    fun selectAll(): LiveData<List<LocalDataSourceSample>>


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(nbaTeam: LocalDataSourceSample)


    @Query("DELETE FROM nba_team_object_table")
    fun deleteAll()
}