package com.java.projet_android_restoy_duciel.Boardgame.domain.model

data class BoardgameDomain(
    val boardgameName:  String,
    val boardgameImage: String?,
    val boardgamePrice: Double,
    val boardgameDesc: String,
    val boardgameCategory: String
)
