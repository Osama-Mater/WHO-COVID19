package com.mattar.whocovid19.presentation

import android.os.Bundle
import com.mattar.whocovid19.R
import com.mattar.whocovid19.library.base.presentation.activity.BaseActivity
import com.mattar.whocovid19.presentation.ui.main.CovidStatusFragment

class CovidStatusActivity : BaseActivity() {
    override val layoutResId: Int = R.layout.covid_status_activity

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, CovidStatusFragment.newInstance())
                .commitNow()
        }
    }
}