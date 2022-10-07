package com.equinox.kehlokeeh.data

import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface ProductsApiClient {

    @Headers("Content-type: application/json")
    @POST("/what")
    suspend fun what(@Body request: WhatRequest): Response<WhatResponse>

}