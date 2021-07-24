package com.example.sampleweatherapp.di

import com.example.sampleweatherapp.MainActivityViewModel
import com.example.sampleweatherapp.data.webservice.WebServiceClient
import org.koin.dsl.module

val webServiceModules = module {
    single { WebServiceClient().create() }
}

val repositoryModules = module {

}

val viewModelModules = module {
    factory { MainActivityViewModel(get()) }
}

val applicationModules = listOf(
    webServiceModules,
    repositoryModules,
    viewModelModules
)