package com.mattar.whocovid19.data.repository

import com.mattar.whocovid19.data.retrofit.response.Covid19Status
import com.mattar.whocovid19.data.retrofit.response.IpApi
import com.mattar.whocovid19.data.retrofit.service.CovidServices

internal class CovidRepositoryImpl(private val covidServices: CovidServices) :
    CovidRepository {
    override suspend fun getIpApi(): IpApi {
        return covidServices.getIpApiAsync()
    }

    override suspend fun getCovidStatus(
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
    ): Covid19Status {
        return covidServices.getCovid19StatusAsync(
            where,
            objectIds,
            time,
            geometry,
            geometryType,
            inSR,
            spatialRel,
            resultType,
            distance,
            units,
            returnGeodetic,
            outFields,
            returnHiddenFields,
            returnGeometry,
            featureEncoding,
            multipatchOption,
            maxAllowableOffset,
            geometryPrecision,
            outSR,
            datumTransformation,
            applyVCSProjection,
            returnIdsOnly,
            returnUniqueIdsOnly,
            returnCountOnly,
            returnExtentOnly,
            returnQueryGeometry,
            returnDistinctValues,
            cacheHint,
            orderByFields,
            groupByFieldsForStatistics,
            outStatistics,
            having,
            resultOffset,
            resultRecordCount,
            returnZ,
            returnM,
            returnExceededLimitFeatures,
            quantizationParameters,
            sqlFormat,
            f,
            token
        )
    }
}