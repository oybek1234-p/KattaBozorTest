package com.example.data.api.product.model

import com.google.gson.annotations.SerializedName

class Image {
    @SerializedName("width")
    var width: Int = 0

    @SerializedName("height")
    var height: Int = 0

    @SerializedName("url")
    var url: String = ""
}