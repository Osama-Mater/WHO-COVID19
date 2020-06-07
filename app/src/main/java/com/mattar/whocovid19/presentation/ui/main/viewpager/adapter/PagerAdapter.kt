package com.mattar.whocovid19.presentation.ui.main.viewpager.adapter

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.mattar.whocovid19.presentation.ui.main.viewpager.fragments.FirstFragment
import com.mattar.whocovid19.presentation.ui.main.viewpager.fragments.StatusCardFragment

class PagerAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int = 2

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> FirstFragment.newInstance()
            else -> StatusCardFragment.newInstance()
        }
    }
}