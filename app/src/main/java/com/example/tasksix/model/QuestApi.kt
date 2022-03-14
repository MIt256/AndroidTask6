package com.example.tasksix.model

import com.example.tasksix.Constants.Companion.URL_ATM
import com.example.tasksix.Constants.Companion.URL_BANK
import com.example.tasksix.Constants.Companion.URL_INFOBOX
import com.example.tasksix.Constants.Companion.URL_QUERY
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface QuestApi {
    @GET(URL_ATM)
    fun getAtmList(@Query (URL_QUERY) city:String): Single<ArrayList<MapPoint>>
    @GET(URL_INFOBOX)
    fun getInfoboxList(@Query (URL_QUERY) city:String): Single<ArrayList<MapPoint>>
    @GET(URL_BANK)
    fun getFilialList(@Query (URL_QUERY) city:String): Single<ArrayList<MapPoint>>
}