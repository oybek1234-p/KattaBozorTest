package com.example.data.api.base

import com.example.data.api.product.model.Product
import kotlinx.coroutines.flow.Flow

interface ProductRepository {

    suspend fun products(): Result<Flow<List<Product>>>
}