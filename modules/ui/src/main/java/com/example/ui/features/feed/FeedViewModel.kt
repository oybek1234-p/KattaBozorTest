package com.example.ui.features.feed

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.data.api.base.ProductRepository
import com.example.data.api.product.model.Product
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class FeedViewModel @Inject constructor(
    private val feedRepository: ProductRepository
) : ViewModel() {

    var products = MutableLiveData<ArrayList<Product>>()
    private var error = MutableLiveData<Throwable>()
    var loading = MutableLiveData<Boolean>()

    private var cache = ArrayList<Product>()

    //Загрузить, если только кэш пуст
    suspend fun loadProducts() {
        if (cache.isEmpty() && loading.value == false) {
            loading.postValue(true)

            val result = feedRepository.products()
            loading.postValue(false)

            if (
                result.isSuccess
                && result.exceptionOrNull() == null
                && result.getOrNull() != null
            ) {
                val productsFlow = result.getOrNull()!!
                productsFlow.collect {
                    cache.clear()
                    cache.addAll(it)
                    products.postValue(cache)
                }
            } else {
                error.postValue(result.exceptionOrNull())
            }
        }
    }
}