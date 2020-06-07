package com.mattar.whocovid19.presentation.ui.main.viewpager.fragments

import com.mattar.whocovid19.R
import com.mattar.whocovid19.library.base.presentation.fragment.BaseContainerFragment

class FirstFragment : BaseContainerFragment() {

    override val layoutResourceId: Int = R.layout.fragment_first

    companion object {
        @JvmStatic
        fun newInstance() = FirstFragment()
    }
}