package com.movies.watch.di

import com.movies.feature_home.screens.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.parameter.parametersOf
import org.koin.dsl.module

val viewModelModule = module {
    viewModel {
        HomeViewModel(
            get(), get(), get(), get()
        )
    }
}