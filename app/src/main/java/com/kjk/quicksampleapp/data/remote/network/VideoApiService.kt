package com.kjk.quicksampleapp.data.remote.network

import com.kjk.quicksampleapp.data.remote.response.VideoNetworkResponse
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

private const val BASE_URL = "https://android-kotlin-fun-mars-server.appspot.com/"

private val interceptor = HttpLoggingInterceptor().apply {
    level = HttpLoggingInterceptor.Level.BODY
}

private val okHttpClient = OkHttpClient.Builder()
    .addInterceptor(interceptor)
    .build()

private val retrofit = Retrofit.Builder()
    .baseUrl(BASE_URL)
    .addConverterFactory(GsonConverterFactory.create())
    .client(okHttpClient)
    .build()

interface VideoApiService {
    @GET("devbytes")
    suspend fun getAllVideos(): VideoNetworkResponse
}

object VideoApi {
    val videoApiService: VideoApiService by lazy {
        retrofit.create(VideoApiService::class.java)
    }
}