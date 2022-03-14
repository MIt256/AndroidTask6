package com.example.tasksix.repository

import android.util.Log
import com.example.tasksix.Constants
import com.example.tasksix.RetrofitObj
import com.example.tasksix.model.MapPoint
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers
import kotlin.math.pow

class Repository {

    fun getPoints():ArrayList<MapPoint>{
        val api = RetrofitObj
        val pointList = ArrayList<MapPoint>()
        try{

            Single.zip(
                api.getAtmList(),
                api.getInfoboxList(),
                api.getFilialList(),
                { atm, infobox, filial ->
                    atm.forEach { it.pointType = Constants.TYPE_ATM }
                    infobox.forEach { it.pointType = Constants.TYPE_INFOBOX }
                    filial.forEach { it.pointType = Constants.TYPE_BANK }
                    atm + infobox + filial
                })
                .map { it.sortedWith(
                    compareBy {
                        Math.sqrt(
                            (Constants.POINT_CENTRAL.latitude - it.gps_x).pow(2) + (Constants.POINT_CENTRAL.longitude - it.gps_y).pow(
                                2
                            )
                        )
                    }
                )
                }
                .flatMapObservable { Observable.fromIterable(it) }
                .take(10)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                    {pointList.add(it)},
                    { Log.e(Constants.ERROR," $it")},
                    {}
                )
        } catch (ex:Exception){
            Log.e(Constants.ERROR," $ex")}
        return pointList
    }
}