package com.java.projet_android_restoy_duciel.Boardgame.view.mapper

import com.java.projet_android_restoy_duciel.Boardgame.domain.model.BoardgameDomain
import com.java.projet_android_restoy_duciel.Boardgame.view.model.*
import fr.upjv.ccm.tp1.model.Boardgame
import fr.upjv.ccm.tp1.model.BoardgameRoom

fun List<BoardgameDomain>.fromDomainToUi(): List<ObjectForUi> {
    val result = mutableListOf<ObjectForUi>()

    groupBy { it.boardgameCategory }
        .forEach { (typeResult, items) ->
            result.add(ObjectDataHeaderBoardgame("Auteur $typeResult"))
            result.addAll(items.map {
                BoardgameUI(
                    name = it.boardgameName,
                    image = it.boardgameImage,
                    price = it.boardgamePrice,
                    desc = it.boardgameDesc,
                    category = it.boardgameCategory
                )
            })
            result.add(ObjectDataFooterBoardgame("Jeu(x): ${items.size}"))
        }
    return result
}

fun BoardgameUI.fromUiToRoom(): BoardgameRoom {

    val bg = BoardgameRoom(
        name = name,
        image = image,
        price = price,
        desc = desc,
        category = category,
        date_added = System.currentTimeMillis()
    )
    return bg

}

fun Boardgame.toUi(): BoardgameUI {

    val bg = BoardgameUI(
        name = name,
        image = image,
        price = price,
        desc = desc,
        category = category ?: "non renseigné"
    )
    return bg

}