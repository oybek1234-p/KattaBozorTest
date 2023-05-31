package com.example.data.api.product.model

import com.google.gson.annotations.SerializedName

class Product {
    @SerializedName("id")
    var id: Int = 0

    @SerializedName("name")
    var name: String = ""

    @SerializedName("brand")
    var brand: String = ""

    @SerializedName("category")
    var category: String = ""

    @SerializedName("merchant")
    var merchant: String = ""

    @SerializedName("attributes")
    var attributes: List<Attribute> = emptyList()

    @SerializedName("image")
    var image: Image? = null
}

