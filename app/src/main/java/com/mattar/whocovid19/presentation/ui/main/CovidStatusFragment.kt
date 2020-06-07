package com.mattar.whocovid19.presentation.ui.main

import android.os.Bundle
import android.view.View
import com.google.android.material.tabs.TabLayoutMediator
import com.mattar.whocovid19.R
import com.mattar.whocovid19.library.base.presentation.fragment.BaseContainerFragment
import com.mattar.whocovid19.presentation.ui.main.viewpager.adapter.PagerAdapter
import kotlinx.android.synthetic.main.covid_status_fragment.*

class CovidStatusFragment : BaseContainerFragment() {

    companion object {
        fun newInstance() = CovidStatusFragment()
    }

    override val layoutResourceId = R.layout.covid_status_fragment

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewPager.adapter = PagerAdapter(this)
        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
        }.attach()
    }
}