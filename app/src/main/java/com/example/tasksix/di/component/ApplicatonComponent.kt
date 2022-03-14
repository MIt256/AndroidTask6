package com.example.tasksix.di.component

import com.example.tasksix.di.modules.NetworkModule
import com.example.tasksix.di.modules.VMModule
import com.example.tasksix.view.MapsActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [NetworkModule::class, VMModule::class])
interface ApplicationComponent {
    fun inject(activity: MapsActivity)
}