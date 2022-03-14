package com.example.tasksix.di.modules

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.tasksix.di.VMKey
import com.example.tasksix.vm.MainViewModel
import com.example.tasksix.vm.VMFactory
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class VMModule {
    @Binds
    @IntoMap
    @VMKey(MainViewModel::class)
    abstract fun bindVM(viewModel: MainViewModel): ViewModel

    @Binds
    abstract fun bindVMFactory(factory: VMFactory): ViewModelProvider.Factory
}