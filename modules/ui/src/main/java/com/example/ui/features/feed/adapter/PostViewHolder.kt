package com.example.ui.features.feed.adapter

import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.math.MathUtils
import androidx.recyclerview.widget.RecyclerView
import com.example.data.api.product.model.Product
import com.example.ui.databinding.ProductItemBinding

class PostViewHolder(val binding: ProductItemBinding) : RecyclerView.ViewHolder(binding.root) {

    var product: Product? = null
        set(value) {
            if (field != value && value != null) {
                field = value
                binding.apply {
                    val image = value.image!!
                    imageView.apply {
                        val params = layoutParams as ConstraintLayout.LayoutParams
                        val ratio =
                            MathUtils.clamp(
                                image.height.toFloat() / image.width.toFloat(),
                                1f,
                                1.5f
                            )
                        params.dimensionRatio = "1:$ratio"
                        layoutParams = params
                    }
                    nameView.text = value.name
                    brandView.text = value.brand
                    category.text = value.merchant
                }
            }
        }

}
    