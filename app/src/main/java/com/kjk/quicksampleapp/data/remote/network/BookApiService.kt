package com.kjk.quicksampleapp.data.remote.network

import com.kjk.quicksampleapp.data.remote.response.BookNetworkResponse
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

private const val BASE_URL = "https://apis.data.go.kr/4050000/libnewbk/"
// TODO github에 push 할 때, 키값 지워야 함.
private const val SERVICE_KEY_ENCODED = ""

private val retrofit by lazy {
    Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}

interface BookApiService {

    @GET("getLibnewbk")
    suspend fun getBookList(
        @Query("serviceKey") serviceKey: String = SERVICE_KEY_ENCODED,
        @Query("numOfRows") numOfRows: Int = 5,
        @Query("pageNo") pageNo: Int = 3,
        @Query("pblshr") publisher: String = "",
        @Query("aut_nm") authorName: String = "",
        @Query("bk_nm") bookName: String = "",
        @Query("srch_bgn_yr") searchBeginYear: Int = 0,
        @Query("srch_end_yr") searchEndYear: Int = 0
    ) : BookNetworkResponse
}

object BookApi {
    val bookApiService: BookApiService by lazy {
        retrofit.create(BookApiService::class.java)
    }
}