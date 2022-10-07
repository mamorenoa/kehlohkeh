package com.equinox.kehlokeeh.model

import com.google.gson.annotations.SerializedName

data class Product(
    @SerializedName("name") var name: String,
    @SerializedName("description") var description: String,
    @SerializedName("rn") var rn: String
)