package com.example.learningassist.ai

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface DeepseekApiService {
    @Headers("Content-Type: application/json")
    @POST("chat/completions")
    fun chatCompletion(@Body request: ChatRequestBean): Call<ChatResponseBean>
} 