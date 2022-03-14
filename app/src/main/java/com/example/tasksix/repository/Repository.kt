package com.example.tasksix.repository

import com.example.tasksix.Constants
import com.example.tasksix.model.QuestApi
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject
import kotlin.math.pow
import kotlin.math.sqrt

class Repository @Inject constructor(private val api: QuestApi){

    fun getPoints() = Single.zip(
            api.getAtmList(),
            api.getInfoboxList(),
            api.getFilialList(),
            { atm, infobox, filial ->
                atm.forEach { it.pointType = Constants.TYPE_ATM }
                infobox.forEach { it.pointType = Constants.TYPE_INFOBOX }
                filial.forEach { it.pointType = Constants.TYPE_BANK }
                atm + infobox + filial
            })
            .map {
                it.sortedWith(
                    compareBy {sqrt((Constants.POINT_CENTRAL.latitude - it.gps_x).pow(2) +
                            (Constants.POINT_CENTRAL.longitude - it.gps_y).pow(2))}
                )
            }
            .flatMapObservable { Observable.fromIterable(it) }
            .take(10)
}