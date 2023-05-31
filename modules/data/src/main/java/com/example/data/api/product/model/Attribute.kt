package com.example.data.api.product.model

import com.google.gson.annotations.SerializedName

class Attribute {
    @SerializedName("name")
    var name: String = ""

    @SerializedName("value")
    var value: String = ""
}