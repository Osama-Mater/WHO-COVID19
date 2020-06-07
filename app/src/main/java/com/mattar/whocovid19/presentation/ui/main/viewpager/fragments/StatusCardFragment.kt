package com.mattar.whocovid19.presentation.ui.main.viewpager.fragments

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import com.mattar.whocovid19.R
import com.mattar.whocovid19.library.base.presentation.extension.observe
import com.mattar.whocovid19.library.base.presentation.fragment.BaseContainerFragment
import com.mattar.whocovid19.presentation.ui.main.CovidStatusViewModel
import kotlinx.android.synthetic.main.fragment_status_card.*
import org.kodein.di.generic.instance

class StatusCardFragment : BaseContainerFragment() {

    override val layoutResourceId: Int = R.layout.fragment_status_card
    private val viewModel: CovidStatusViewModel by instance()
    private val stateObserver = Observer<CovidStatusViewModel.ViewState> {
        txt_country.text = it.countryCode + resources.getString(R.string.country_situation)
        txt_deathCount.text = it.totalDeaths + resources.getString(R.string.total_deaths)
        txt_totalCount.text = it.totalCases
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observe(viewModel.stateLiveData, stateObserver)
        viewModel.loadData()
    }

    companion object {
        @JvmStatic
        fun newInstance() = StatusCardFragment()
    }
}