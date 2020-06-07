package com.mattar.whocovid19.data.repository

import com.mattar.whocovid19.data.retrofit.response.Covid19Status
import com.mattar.whocovid19.data.retrofit.response.IpApi

internal interface CovidRepository {
    suspend fun getIpApi(): IpApi
    suspend fun getCovidStatus(
        where: String,
        objectIds: String,
        time: String,
        geometry: String,
        geometryType: String,
        inSR: String,
        spatialRel: String,
        resultType: String,
        distance: String,
        units: String,
        returnGeodetic: String,
        outFields: String,
        returnHiddenFields: String,
        returnGeometry: String,
        featureEncoding: String,
        multipatchOption: String,
        maxAllowableOffset: String,
        geometryPrecision: String,
        outSR: String,
        datumTransformation: String,
        applyVCSProjection: String,
        returnIdsOnly: String,
        returnUniqueIdsOnly: String,
        returnCountOnly: String,
        returnExtentOnly: String,
        returnQueryGeometry: String,
        returnDistinctValues: String,
        cacheHint: String,
        orderByFields: String,
        groupByFieldsForStatistics: String,
        outStatistics: String,
        having: String,
        resultOffset: String,
        resultRecordCount: String,
        returnZ: String,
        returnM: String,
        returnExceededLimitFeatures: String,
        quantizationParameters: String,
        sqlFormat: String,
        f: String,
        token: String
    ): Covid19Status
}