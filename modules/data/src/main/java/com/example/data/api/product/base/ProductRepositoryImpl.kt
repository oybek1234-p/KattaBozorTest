package com.example.data.api.base

import android.util.Log
import com.example.data.api.product.model.Product
import com.example.data.network.NetworkApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class ProductRepositoryImpl @Inject constructor(
    private val productApi: NetworkApi
) : ProductRepository {

    companion object {
        private const val TAG = "ProductRepositoryImpl"
    }

    private val api by lazy {
        productApi.createApi(ProductApi.BASE_URL, ProductApi::class.java)
    }

    override suspend fun products(): Result<Flow<List<Product>>> {
        val result = api.products()
        return if (result.isSuccessful) {
            val flow = flow {
                result.body()?.let { it ->
                    emit(it)
                }
            }
            Result.success(flow)
        } else {
            val error = result.errorBody()?.string()
            Log.e(TAG, "products: ${result.errorBody()}")
            Result.failure(Throwable(error))
        }
    }
}