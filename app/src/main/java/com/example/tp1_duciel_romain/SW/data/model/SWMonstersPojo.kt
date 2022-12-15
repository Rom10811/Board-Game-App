package com.example.tp1_duciel_romain.SW.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


@Entity(tableName = "sw_monsters_object_table")
data class SWMonstersRoom(
    @ColumnInfo(name = "name")
    val name: String,

    @ColumnInfo(name = "icon")
    val icon: String,

    @ColumnInfo(name = "type")
    val type: String,
){
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0
}

data class SWMonstersRetrofit(
    @Expose
    @SerializedName("image_filename")
    val image: String,


    @Expose
    @SerializedName("name")
    val name: String,


    @Expose
    @SerializedName("element")
    val type: String
)
