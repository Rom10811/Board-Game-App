package com.example.tp1_duciel_romain.view.model

sealed class MyObjectForRecyclerView()

data class ObjectDataHeaderSample(val header: String) : MyObjectForRecyclerView()
data class ObjectDataFooterSample(val footer: String) : MyObjectForRecyclerView()

data class RecyclerViewData(
    val teamName: String,
    val conference: String,
    val teamRank: String,
    val teamLogo: String,
): MyObjectForRecyclerView()

