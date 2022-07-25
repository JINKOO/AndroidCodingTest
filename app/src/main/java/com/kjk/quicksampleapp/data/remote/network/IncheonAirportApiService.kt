package com.kjk.quicksampleapp.data.remote.network

import com.google.gson.GsonBuilder
import com.kjk.quicksampleapp.data.remote.response.ResponseFromNetwork
import com.kjk.quicksampleapp.data.remote.response.ServiceAirlinesFromNetwork
import com.kjk.quicksampleapp.data.remote.response.ServiceAirlinesResponse
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

private const val BASE_URL = "http://apis.data.go.kr/B551177/"
private const val SERVICE_KEY =
    ""

interface IncheonAirportApiService {

    /**
     *  인천국제공항에 취항하고 있는 항공사 조회,
     *  @param airlineIata
     *  @param airlineIcao
     *  위 2개의 값이 "" 이면, 취항 중인 모든 항공사가 response로 온다.
     */
    @GET("StatusOfSrvAirlines/getServiceAirlineInfo")
    suspend fun getServiceAirlines(
        @Query("serviceKey") serviceKey: String = SERVICE_KEY,
        @Query("airline_iata") airlineIata: String = "",
        @Query("airline_icao") airlineIcao: String = "",
        @Query("type") type: String = "json"
    ): ServiceAirlinesFromNetwork


    @GET("PaxFltSched/getPaxFltSchedArrivals")
    suspend fun getFlightArrivals(
        @Query("serviceKey") serviceKey: String = SERVICE_KEY,
        @Query("numOfRows") numOfRows: Int = 100,
        @Query("pageNo") pageNo: Int = 1,
        @Query("lang") lang: String = "",
        @Query("airport") airport: String = "",
        @Query("type") responseType: String = "json"
    ): ResponseFromNetwork


    @GET("PaxFltSched/getPaxFltSchedDepartures")
    suspend fun getFlightDepartures(
        @Query("serviceKey") serviceKey: String,
        @Query("numOfRows") numOfRows: Int,
        @Query("pageNo") pageNo: Int,
        @Query("lang") lang: String,
        @Query("airport") airport: String,
        @Query("type") responseType: String = "json"
    )
}

object IncheonAirportApi {

    private val gson = GsonBuilder()
        .setLenient()
        .create()

    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build()

    val incheonAirportApiService: IncheonAirportApiService by lazy {
        retrofit.create(IncheonAirportApiService::class.java)
    }
}