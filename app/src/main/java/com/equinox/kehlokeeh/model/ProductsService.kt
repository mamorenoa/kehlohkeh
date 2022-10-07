package com.equinox.kehlokeeh.model

import com.equinox.kehlokeeh.data.ProductsApiClient
import com.equinox.kehlokeeh.data.RetrofitBuilder
import com.equinox.kehlokeeh.data.WhatRequest
import com.equinox.kehlokeeh.data.WhatResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ProductsService {

    private val retrofit = RetrofitBuilder.build()

    suspend fun get(request: WhatRequest): WhatResponse? {
        return withContext(Dispatchers.IO) {
            val response = retrofit.create(ProductsApiClient::class.java).what(request)
            response.body()
        }
    }
}