package com.mattar.whocovid19.data.retrofit.response

import com.squareup.moshi.Json

internal data class Covid19Status(val features: List<Features>)
internal data class Features(val attributes: Attributes)
internal data class Attributes(
    @field:Json(name = "CumCase") val cumCase: Int,
    @field:Json(name = "CumDeath") val cumDeath: Int
)