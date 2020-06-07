package com.mattar.whocovid19.data

import com.mattar.whocovid19.data.repository.CovidRepositoryImpl
import com.mattar.whocovid19.data.retrofit.service.CovidServices
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.singleton
import retrofit2.Retrofit

internal val dataModule = Kodein.Module("CovidStatusDataModule") {

    bind<CovidRepositoryImpl>() with singleton { CovidRepositoryImpl(instance()) }

    bind() from singleton { instance<Retrofit>().create(CovidServices::class.java) }
}
