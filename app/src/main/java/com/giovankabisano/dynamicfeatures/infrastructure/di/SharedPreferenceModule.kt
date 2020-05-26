package com.giovankabisano.dynamicfeatures.infrastructure.di

import com.giovankabisano.dynamicfeatures.infrastructure.repository.ConfigRepository
import com.giovankabisano.dynamicfeatures.presentation.SharedPreferenceViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val sharedPreferenceModule = module {

    single {
        ConfigRepository(context = androidContext())
    }

    viewModel {
        SharedPreferenceViewModel(
            configRepository = get()
        )
    }

}
