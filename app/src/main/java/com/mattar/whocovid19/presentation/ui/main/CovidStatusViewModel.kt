package com.mattar.whocovid19.presentation.ui.main

import androidx.lifecycle.viewModelScope
import com.mattar.whocovid19.data.repository.CovidRepositoryImpl
import com.mattar.whocovid19.data.retrofit.response.Covid19Status
import com.mattar.whocovid19.data.retrofit.response.IpApi
import com.mattar.whocovid19.library.base.presentation.viewmodel.BaseAction
import com.mattar.whocovid19.library.base.presentation.viewmodel.BaseViewModel
import com.mattar.whocovid19.library.base.presentation.viewmodel.BaseViewState
import kotlinx.coroutines.launch

internal class CovidStatusViewModel(
    private val covidRepositoryImpl: CovidRepositoryImpl
) : BaseViewModel<CovidStatusViewModel.ViewState, CovidStatusViewModel.Action>(ViewState()) {

    override fun onLoadData() {
        super.onLoadData()
        getCountryISOCode()
    }

    private fun getCountryISOCode() {
        viewModelScope.launch {
            covidRepositoryImpl.getIpApi().also { ipApi ->
                covidRepositoryImpl.getCovidStatus(
                    "ISO_2_CODE+%3D+%27" + ipApi.countryCode + "%27+",
                    "", "", "",
                    "esriGeometryEnvelope",
                    "",
                    "esriSpatialRelIntersects", "none", "0.0",
                    "esriSRUnit_Meter",
                    "false",
                    "CumCase%2CCumDeath",
                    "false",
                    "false",
                    "esriDefault",
                    "xyFootprint",
                    "",
                    "",
                    "",
                    "",
                    "false",
                    "false",
                    "false",
                    "false",
                    "false",
                    "false",
                    "false",
                    "false",
                    "date_epicrv+DESC",
                    "",
                    "",
                    "",
                    "",
                    "1",
                    "false",
                    "false",
                    "false",
                    "",
                    "none",
                    "pjson",
                    ""
                ).also { covidStatus ->
                    if (covidStatus != null) {
                        sendAction(Action.CovidStatusLoadSuccess(covidStatus, ipApi))
                    } else {
                        sendAction(Action.CovidStatusLoadFailure)
                    }
                }
            }
        }
    }

    override fun onReduceState(viewAction: Action) = when (viewAction) {
        is Action.CovidStatusLoadSuccess -> state.copy(
            isLoading = false,
            isError = false,
            countryCode = viewAction.ipApi.countryCode,
            totalCases = viewAction.covid19Status.features[0].attributes.cumCase.toString(),
            totalDeaths = viewAction.covid19Status.features[0].attributes.cumDeath.toString()
        )
        is Action.CovidStatusLoadFailure -> state.copy(
            isLoading = false,
            isError = true,
            countryCode = "",
            totalCases = "",
            totalDeaths = ""
        )
    }

    internal data
    class ViewState(
        val isLoading: Boolean = true,
        val isError: Boolean = false,
        val countryCode: String = "",
        val totalCases: String = "",
        val totalDeaths: String = ""
    ) : BaseViewState

    internal sealed class Action : BaseAction {
        class CovidStatusLoadSuccess(val covid19Status: Covid19Status, val ipApi: IpApi) : Action()
        object CovidStatusLoadFailure : Action()
    }
}