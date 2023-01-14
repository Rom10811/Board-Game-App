package com.java.projet_android_restoy_duciel.SW.view.mapper

import com.java.projet_android_restoy_duciel.SW.domain.model.SWMonstersDomain
import com.java.projet_android_restoy_duciel.SW.view.model.ObjectDataFooterSW
import com.java.projet_android_restoy_duciel.SW.view.model.ObjectDataHeaderSW
import com.java.projet_android_restoy_duciel.SW.view.model.ObjectForUi
import com.java.projet_android_restoy_duciel.SW.view.model.SWMonstersUi

fun List<SWMonstersDomain>.fromDomainToUi(): List<ObjectForUi> {
    val result = mutableListOf<ObjectForUi>()

    groupBy { it.monsterType }
        .forEach { (typeResult, items) ->
            result.add(ObjectDataHeaderSW("Type $typeResult"))
            result.addAll(items.map {
                SWMonstersUi(
                    name = it.monsterName,
                    icon = it.monsterIcon,
                    type = it.monsterType
                )
            })
            result.add(ObjectDataFooterSW("Monstre(s): ${items.size}"))
        }
    return result
}