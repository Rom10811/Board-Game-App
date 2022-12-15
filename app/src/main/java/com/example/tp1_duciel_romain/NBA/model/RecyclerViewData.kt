package com.example.tp1_duciel_romain.NBA.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

sealed class MyObjectForRecyclerView

data class ObjectDataHeaderSample(val header: String) : MyObjectForRecyclerView()
data class ObjectDataFooterSample(val footer: String) : MyObjectForRecyclerView()

data class RecyclerViewData(
    val teamName: String,
    val teamConference: String,
    val teamRank: Int,
    val teamLogo: String,
): MyObjectForRecyclerView()

@Entity(tableName = "nba_team_object_table")
data class LocalDataSourceSample(
    @ColumnInfo(name = "name")
    val name: String,

    @ColumnInfo(name = "conference")
    val conference: String,

    @ColumnInfo(name = "rank")
    val rank: Int,

    @ColumnInfo(name = "logo")
    val logo: String,
){
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0
}