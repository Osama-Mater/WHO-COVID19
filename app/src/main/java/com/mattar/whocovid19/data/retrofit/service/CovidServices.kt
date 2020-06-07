package com.mattar.whocovid19.data.retrofit.service

import com.mattar.whocovid19.data.retrofit.response.Covid19Status
import com.mattar.whocovid19.data.retrofit.response.IpApi
import retrofit2.http.GET
import retrofit2.http.Query

internal interface CovidServices {
    @GET("http://ip-api.com/json")
    suspend fun getIpApiAsync(): IpApi

    @GET("/5T5nSi527N4F7luB/arcgis/rest/services/COVID19_hist_cases_adm0_v5_view/FeatureServer/0/query")
    suspend fun getCovid19StatusAsync(
        @Query("where", encoded = true) where: String,
        @Query("objectIds", encoded = true) objectIds: String,
        @Query("time", encoded = true) time: String,
        @Query("geometry", encoded = true) geometry: String,
        @Query("geometryType", encoded = true) geometryType: String,
        @Query("inSR", encoded = true) inSR: String,
        @Query("spatialRel", encoded = true) spatialRel: String,
        @Query("resultType", encoded = true) resultType: String,
        @Query("distance", encoded = true) distance: String,
        @Query("units", encoded = true) units: String,
        @Query("returnGeodetic", encoded = true) returnGeodetic: String,
        @Query("outFields", encoded = true) outFields: String,
        @Query("returnHiddenFields", encoded = true) returnHiddenFields: String,
        @Query("returnGeometry", encoded = true) returnGeometry: String,
        @Query("featureEncoding", encoded = true) featureEncoding: String,
        @Query("multipatchOption", encoded = true) multipatchOption: String,
        @Query("maxAllowableOffset", encoded = true) maxAllowableOffset: String,
        @Query("geometryPrecision", encoded = true) geometryPrecision: String,
        @Query("outSR", encoded = true) outSR: String,
        @Query("datumTransformation", encoded = true) datumTransformation: String,
        @Query("applyVCSProjection", encoded = true) applyVCSProjection: String,
        @Query("returnIdsOnly", encoded = true) returnIdsOnly: String,
        @Query("returnUniqueIdsOnly", encoded = true) returnUniqueIdsOnly: String,
        @Query("returnCountOnly", encoded = true) returnCountOnly: String,
        @Query("returnExtentOnly", encoded = true) returnExtentOnly: String,
        @Query("returnQueryGeometry", encoded = true) returnQueryGeometry: String,
        @Query("returnDistinctValues", encoded = true) returnDistinctValues: String,
        @Query("cacheHint", encoded = true) cacheHint: String,
        @Query("orderByFields", encoded = true) orderByFields: String,
        @Query("groupByFieldsForStatistics", encoded = true) groupByFieldsForStatistics: String,
        @Query("outStatistics", encoded = true) outStatistics: String,
        @Query("having", encoded = true) having: String,
        @Query("resultOffset", encoded = true) resultOffset: String,
        @Query("resultRecordCount", encoded = true) resultRecordCount: String,
        @Query("returnZ", encoded = true) returnZ: String,
        @Query("returnM", encoded = true) returnM: String,
        @Query("returnExceededLimitFeatures", encoded = true) returnExceededLimitFeatures: String,
        @Query("quantizationParameters", encoded = true) quantizationParameters: String,
        @Query("sqlFormat", encoded = true) sqlFormat: String,
        @Query("f", encoded = true) f: String,
        @Query("token", encoded = true) token: String
    ): Covid19Status
}