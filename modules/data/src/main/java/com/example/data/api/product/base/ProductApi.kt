package com.example.data.api.base

import com.example.data.api.product.model.Product
import retrofit2.Response
import retrofit2.http.GET

interface ProductApi {

    companion object {
        const val BASE_URL = "https://www.kattabozor.uz/hh/test/api/v1/"
    }

    @GET("offers")
    suspend fun products(): Response<List<Product>>
}