package com.kjk.quicksampleapp.data.remote.network

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.kjk.quicksampleapp.data.remote.response.ResponseFromNetwork
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

private const val BASE_URL = "http://apis.data.go.kr/B551177/PaxFltSched/"
private const val SERVICE_KEY = "LuWoYg/LjEO2msXcm1LziDtVfMa3pdsvW6bffUuaXrP7YZMjRx9gKe6qzoAb53BlCNpeXe1N547rnwMQRi2ptQ=="

private val gson = GsonBuilder()
    .setLenient()
    .create()

private val retrofit = Retrofit.Builder()
    .baseUrl(BASE_URL)
    .addConverterFactory(GsonConverterFactory.create(gson))
    .build()

interface FlightScheduleApiService {

    @GET("getPaxFltSchedArrivals")
    suspend fun getFlightArrivals(
        @Query("serviceKey") serviceKey: String = SERVICE_KEY,
        @Query("numOfRows") numOfRows: Int = 100,
        @Query("pageNo") pageNo: Int = 1,
        @Query("lang") lang: String = "",
        @Query("airport") airport: String = "",
        @Query("type") responseType: String = "json"
    ) : ResponseFromNetwork

    @GET("getPaxFltSchedDepartures")
    suspend fun getFlightDepartures(
        @Query("serviceKey") serviceKey: String,
        @Query("numOfRows") numOfRows: Int,
        @Query("pageNo") pageNo: Int,
        @Query("lang") lang: String,
        @Query("airport") airport: String,
        @Query("type") responseType: String = "json"
    )
}

object FlightScheduleApi {
    val flightScheduleApiService: FlightScheduleApiService by lazy {
        retrofit.create(FlightScheduleApiService::class.java)
    }
}