package com.example.tasksix.presentation.di.modules

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.tasksix.presentation.di.VMKey
import com.example.tasksix.presentation.vm.MainViewModel
import com.example.tasksix.presentation.vm.VMFactory
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