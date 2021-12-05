package org.sopt.androidseminar1

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object GitServiceCreator {
    private const val BASE_URL = "https://api.github.com"

    private val retrofit: Retrofit = Retrofit
        .Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val gitService : GitService = retrofit.create(GitService::class.java)
}