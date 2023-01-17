package com.java.projet_android_restoy_duciel.Boardgame.data.mapper

import com.java.projet_android_restoy_duciel.Boardgame.domain.model.BoardgameDomain
import fr.upjv.ccm.tp1.model.Boardgame
import fr.upjv.ccm.tp1.model.BoardgameRoom

fun Boardgame.toRoom(): BoardgameRoom {
    return BoardgameRoom(
        name = name,
        image = image,
        price = price,
        desc = desc,
        category = category,
        date_added = System.currentTimeMillis()
    )
}

fun List<BoardgameRoom>.fromRoomToDomain(): List<BoardgameDomain>{
    return map {
        BoardgameDomain(
            boardgameName = it.name,
            boardgameImage = it.image,
            boardgamePrice = it.price,
            boardgameDesc = it.desc,
            boardgameCategory = it.category
        )
    }
}