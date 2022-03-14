package com.example.tasksix.vm

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.tasksix.Constants.Companion.ERROR
import com.example.tasksix.Constants.Companion.POINT_CENTRAL
import com.example.tasksix.Constants.Companion.TYPE_ATM
import com.example.tasksix.Constants.Companion.TYPE_BANK
import com.example.tasksix.Constants.Companion.TYPE_INFOBOX
import com.example.tasksix.model.MapPoint
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable.fromIterable
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import com.example.tasksix.RetrofitObj
import com.example.tasksix.repository.Repository
import kotlinx.coroutines.withContext
import java.lang.Math.sqrt
import kotlin.math.pow

class MainViewModel: ViewModel() {
    private var mapPointList: MutableLiveData<ArrayList<MapPoint>> = MutableLiveData()

    fun isListEmpty():Boolean=
        mapPointList.value.isNullOrEmpty()

    fun getPointList() = mapPointList

     fun getData() {
         CoroutineScope(Dispatchers.IO).launch() {
         val repo = Repository()
             withContext(Dispatchers.Main) { mapPointList.value = repo.getPoints()}
         }
    }
}

