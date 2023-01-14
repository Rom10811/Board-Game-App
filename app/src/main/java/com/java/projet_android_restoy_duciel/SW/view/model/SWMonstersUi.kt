package com.java.projet_android_restoy_duciel.SW.view.model


sealed class ObjectForUi()

data class ObjectDataHeaderSW(val header: String): ObjectForUi()
data class ObjectDataFooterSW(val footer: String): ObjectForUi()

data class SWMonstersUi(
    val name: String,
    val icon: String,
    val type: String
): ObjectForUi()