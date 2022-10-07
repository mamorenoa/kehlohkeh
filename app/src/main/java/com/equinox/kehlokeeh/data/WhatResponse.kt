package com.equinox.kehlokeeh.data

import com.google.gson.annotations.SerializedName

data class WhatResponse(
    @SerializedName("user") var user: UserResponse,
    @SerializedName("rn") var rn: RnResponse
)

data class UserResponse(
    @SerializedName("_id") var id: String
)

data class RnResponse(
    @SerializedName("_id") var id: String,
    @SerializedName("product_data") var productData: ProductDataResponse,
    @SerializedName("isFavourite") var isFavourite: Boolean,
    @SerializedName("places") var places: List<PlaceResponse>
)

data class ProductDataResponse(
    @SerializedName("enterprise_name") var enterpriseName: String,
    @SerializedName("date_registering") var dateRegistering: String,
    @SerializedName("address") var address: String,
    @SerializedName("city") var city: String,
    @SerializedName("province") var province: String,
    @SerializedName("social_address") var socialAddress: String,
    @SerializedName("activities") var activities: List<String>
)

data class PlaceResponse(
    @SerializedName("name") var name: String,
    @SerializedName("address") var address: String,
    @SerializedName("location") var location: LocationResponse,
    @SerializedName("price") var price: Double
)

data class LocationResponse(
    @SerializedName("lat") var lat: Double,
    @SerializedName("lng") var lng: Double,
)