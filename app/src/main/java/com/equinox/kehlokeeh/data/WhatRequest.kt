package com.equinox.kehlokeeh.data

import com.equinox.kehlokeeh.model.Place
import com.equinox.kehlokeeh.model.User
import com.google.gson.annotations.SerializedName

data class WhatRequest(
    @SerializedName("user") var user: User,
    @SerializedName("rn") var rn: String,
    @SerializedName("place") var place: Place
)
