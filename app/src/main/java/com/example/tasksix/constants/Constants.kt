package com.example.tasksix.constants

import com.google.android.gms.maps.model.LatLng

class Constants {
    companion object {
        const val URL_ATM = "/api/atm"
        const val URL_INFOBOX ="/api/infobox"
        const val URL_BANK = "/api/filials_info"
        const val URL_BASE = "https://belarusbank.by"
        const val URL_QUERY = "city"

        const val GOMEL = "Гомель"

        const val ERROR = "Error"

        const val TYPE_ATM = "Банкомат"
        const val TYPE_INFOBOX = "Инфокиоск"
        const val TYPE_BANK = "Отделение банка"

        val POINT_CENTRAL =  LatLng(52.425163, 31.015039)

    }
}