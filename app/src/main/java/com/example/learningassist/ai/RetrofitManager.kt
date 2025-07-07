package com.example.learningassist.ai

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitManager {
    private val retrofit = Retrofit.Builder()
        .baseUrl("https://api.deepseek.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val api: DeepseekApiService = retrofit.create(DeepseekApiService::class.java)
} 