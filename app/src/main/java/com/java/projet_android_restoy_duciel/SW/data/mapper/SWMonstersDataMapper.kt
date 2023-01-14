package com.java.projet_android_restoy_duciel.SW.data.mapper

import com.java.projet_android_restoy_duciel.SW.data.model.SWMonstersRetrofit
import com.java.projet_android_restoy_duciel.SW.data.model.SWMonstersRoom
import com.java.projet_android_restoy_duciel.SW.domain.model.SWMonstersDomain

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