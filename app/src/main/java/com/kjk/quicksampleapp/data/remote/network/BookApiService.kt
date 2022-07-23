package com.kjk.quicksampleapp.data.remote.network

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.kjk.quicksampleapp.data.remote.response.BookNetworkResponse
import com.kjk.quicksampleapp.data.remote.response.BookResponse
import com.kjk.quicksampleapp.data.remote.response.VideoNetworkResponse
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

private const val BASE_URL = "https://android-kotlin-fun-mars-server.appspot.com/" //"http://apis.data.go.kr/4050000/libnewbk/"

// TODO github에 push 할 때, 키값 지워야 함.
private const val SERVICE_KEY_ENCODED = "LuWoYg%2FLjEO2msXcm1LziDtVfMa3pdsvW6bffUuaXrP7YZMjRx9gKe6qzoAb53BlCNpeXe1N547rnwMQRi2ptQ%3D%3D"

private val gson: Gson = GsonBuilder()
    .setLenient()
    .create()

private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build()

interface BookApiService {

    @GET("devbytes")
    suspend fun getVideoList(): VideoNetworkResponse

    @GET("getLibnewbk")
    suspend fun getBookList(
        @Query("serviceKey") serviceKey: String = SERVICE_KEY_ENCODED,
        @Query("numOfRows") numOfRows: Int = 5,
        @Query("pageNo") pageNo: Int = 3,
//        @Query("pblshr") publisher: String = "",
//        @Query("aut_nm") authorName: String = "",
//        @Query("bk_nm") bookName: String = "",
//        @Query("srch_bgn_yr") searchBeginYear: String = "",
//        @Query("srch_end_yr") searchEndYear: String = ""
    ) : BookNetworkResponse
}

object BookApi {
    val bookApiService: BookApiService by lazy {
        retrofit.create(BookApiService::class.java)
    }
}