package com.example.bankodemia.data.network.bankodemia.api.transaction

import com.example.bankodemia.data.model.Transaction
import okhttp3.RequestBody
import retrofit2.Response
import retrofit2.http.*

interface TransactionsApi {
    @POST("/transactions")
    suspend fun makeSelfTransaction(@Body parameters: RequestBody): Response<Transaction.PostResponse>

    @GET("/transactions/me")
    suspend fun getSelfTransactions(): Response<Transaction.GetResponse>

    @Multipart
    @GET("/transactions/id")
    suspend fun getTransactionDetail(@Part("id") transactionId: RequestBody): Response<Transaction.PostResponse>

}