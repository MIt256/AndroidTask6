package com.example.tasksix.vm

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.tasksix.Constants.Companion.ERROR
import com.example.tasksix.Constants.Companion.GOMEL
import com.example.tasksix.model.MapPoint
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import com.example.tasksix.repository.Repository
import java.lang.Exception
import javax.inject.Inject

class MainViewModel @Inject constructor(private val repo: Repository): ViewModel() {
    private var mapPointList: MutableLiveData<ArrayList<MapPoint>> = MutableLiveData()

    fun isListEmpty():Boolean=
        mapPointList.value.isNullOrEmpty()

    fun getPointList() = mapPointList

     fun getData() {
         CoroutineScope(Dispatchers.IO).launch {
             try {
                 val points = ArrayList<MapPoint>()
                 repo.getPoints(GOMEL)
                     .subscribeOn(Schedulers.io())
                     .observeOn(AndroidSchedulers.mainThread())
                     .subscribe(
                         { points.add(it) },
                         { Log.e(ERROR, " $it") },
                         { mapPointList.value = points }
                     )
             } catch (ex: Exception) {Log.e(ERROR, " $ex")}
         }
    }
}

