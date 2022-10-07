package com.equinox.kehlokeeh.model

import com.google.gson.annotations.SerializedName

data class Place(
    @SerializedName("name") var name: String,
    @SerializedName("address") var address: String,
    @SerializedName("location") var location: Location
)

data class Location(
    @SerializedName("lat") var lat: Double,
    @SerializedName("lng") var lng: Double,
)
