package com.example.ui.features.feed.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.data.api.product.model.Product

class PostDiff : DiffUtil.ItemCallback<Product>() {

    override fun areContentsTheSame(oldItem: Product, newItem: Product): Boolean {
        return oldItem.id == newItem.id
                && oldItem.brand == newItem.brand
                && oldItem.name == newItem.name
                && oldItem.image == newItem.image
    }

    override fun areItemsTheSame(oldItem: Product, newItem: Product): Boolean {
        return oldItem.id == newItem.id
    }
}