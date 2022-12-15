package com.example.tp1_duciel_romain.SW.data.mapper

import com.example.tp1_duciel_romain.SW.data.model.SWMonstersRetrofit
import com.example.tp1_duciel_romain.SW.data.model.SWMonstersRoom
import com.example.tp1_duciel_romain.SW.domain.model.SWMonstersDomain

fun SWMonstersRetrofit.toRoom(): SWMonstersRoom {
    return SWMonstersRoom(
        name = name,
        icon = image,
        type = type
    )
}

fun List<SWMonstersRoom>.fromRoomToDomain(): List<SWMonstersDomain>{
    return map {
        SWMonstersDomain(
            monsterName = it.name,
            monsterIcon = it.icon,
            monsterType = it.type
        )
    }
}