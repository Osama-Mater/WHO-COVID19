package com.mattar.whocovid19

import android.content.Context
import com.google.android.play.core.splitcompat.SplitCompatApplication
import com.mattar.whocovid19.data.dataModule
import com.mattar.whocovid19.library.base.baseModule
import com.mattar.whocovid19.presentation.presentationModule
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.androidXModule
import timber.log.Timber

/*
False positive "Unused symbol" for a custom Android application class referenced in AndroidManifest.xml file:
https://youtrack.jetbrains.net/issue/KT-27971
*/
class CovidStatusApplication : SplitCompatApplication(), KodeinAware {
    override val kodein = Kodein.lazy {
        import(androidXModule(this@CovidStatusApplication))
        import(networkModule)
        import(baseModule)
        import(dataModule)
        import(presentationModule)
//        importAll(FeatureKodeinModule.kodeinModule)
//        externalSources.add(FragmentArgsExternalSource())
    }

    private lateinit var context: Context

    override fun onCreate() {
        super.onCreate()

        context = this

        initTimber()
    }


    private fun initTimber() {
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }
}
