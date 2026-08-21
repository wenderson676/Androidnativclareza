package com.wenderson676.clarezaapkandroidv1.network

import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object ApiClient {
    private const val BASE_URL = "https://api.example.com/" // Replace with real endpoint or make configurable

    val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(MoshiConverterFactory.create())
        .build()
}

interface ApiService {
    // Define retrofit endpoints mirroring the web app APIs
}
