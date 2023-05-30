package com.example.data.api.base

import dagger.Binds
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@InstallIn(ViewModelComponent::class)
abstract class ProductRepositoryModule {

    @Binds
    abstract fun bindProductRepositoryImpl(productRepositoryImpl: ProductRepositoryImpl): ProductRepository
}