package com.example.ui.feed.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.data.api.model.Product
import com.example.ui.databinding.ProductItemBinding

class PostsAdapter(
    private val inflater: LayoutInflater,
    private val onClicked: (post: Product) -> Unit
) :
    ListAdapter<Product, PostViewHolder>(PostDiff()) {

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        holder.apply {
            product = getItem(position)
            binding.root.setOnClickListener {
                onClicked.invoke(getItem(position))
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        return PostViewHolder(
            ProductItemBinding.inflate(
                inflater,
                parent,
                false
            )
        )
    }
}