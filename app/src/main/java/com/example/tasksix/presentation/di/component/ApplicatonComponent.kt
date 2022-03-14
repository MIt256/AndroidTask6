package com.example.tasksix.presentation.di.component

import com.example.tasksix.presentation.di.modules.NetworkModule
import com.example.tasksix.presentation.di.modules.VMModule
import com.example.tasksix.presentation.view.MapsActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [NetworkModule::class, VMModule::class])
interface ApplicationComponent {
    fun inject(activity: MapsActivity)
}