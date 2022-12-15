package com.example.tp1_duciel_romain.SW.view.mapper

import com.example.tp1_duciel_romain.SW.domain.model.SWMonstersDomain
import com.example.tp1_duciel_romain.SW.view.model.ObjectDataFooterSW
import com.example.tp1_duciel_romain.SW.view.model.ObjectDataHeaderSW
import com.example.tp1_duciel_romain.SW.view.model.ObjectForUi
import com.example.tp1_duciel_romain.SW.view.model.SWMonstersUi

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