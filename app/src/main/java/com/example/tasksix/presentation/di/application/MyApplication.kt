package com.example.tasksix.presentation.di.application

import android.app.Application
import com.example.tasksix.presentation.di.component.ApplicationComponent
import com.example.tasksix.presentation.di.component.DaggerApplicationComponent

class MyApplication : Application() {
    private val component by lazy { DaggerApplicationComponent.create() }

    fun getApplicationComponent(): ApplicationComponent = component
}