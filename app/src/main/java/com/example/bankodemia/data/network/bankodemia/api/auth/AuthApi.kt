package com.example.bankodemia.data.network.bankodemia.api.auth

import com.example.bankodemia.data.model.auth.Auth
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthApi {
    @POST("auth/login")
    suspend fun login(@Body login: Auth.Login): Response<Auth.Response>
}