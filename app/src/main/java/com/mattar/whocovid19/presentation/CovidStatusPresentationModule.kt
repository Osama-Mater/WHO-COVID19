package com.mattar.whocovid19.presentation

import androidx.fragment.app.Fragment
import com.mattar.whocovid19.library.base.di.KotlinViewModelProvider
import com.mattar.whocovid19.presentation.ui.main.CovidStatusViewModel
import org.kodein.di.Kodein
import org.kodein.di.android.x.AndroidLifecycleScope
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.scoped
import org.kodein.di.generic.singleton

internal val presentationModule = Kodein.Module("CovidStatusPresentationModule") {
    bind<CovidStatusViewModel>() with scoped<Fragment>(AndroidLifecycleScope).singleton {
        KotlinViewModelProvider.of(context) { CovidStatusViewModel(instance()) }
    }
}