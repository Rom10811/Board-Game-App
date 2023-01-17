package com.java.projet_android_restoy_duciel.Boardgame.view.model

sealed class ObjectForUi()

data class ObjectDataHeaderBoardgame(val header: String): ObjectForUi()
data class ObjectDataFooterBoardgame(val footer: String): ObjectForUi()

data class BoardgameUI(
    val name:  String,
    val image: String?,
    val price: Double,
    val desc: String,
    val category: String
): ObjectForUi()