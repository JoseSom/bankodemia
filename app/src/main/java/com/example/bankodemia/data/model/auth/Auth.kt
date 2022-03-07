package com.example.bankodemia.data.model.auth

object Auth {
    init { }

    data class Response(
        val token: String,
        val expiresIn: String
    )

    data class Login(
        val email: String,
        val password: String
    )
}