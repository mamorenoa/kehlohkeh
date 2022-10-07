package com.equinox.kehlokeeh.model

import com.equinox.kehlokeeh.data.WhatRequest
import com.equinox.kehlokeeh.data.WhatResponse
import com.equinox.kehlokeeh.places

class WhatsRepository {

    private val api = ProductsService()

    suspend fun get(rn: String): WhatResponse? =
        api.get(WhatRequest(User("1"), rn, places[0]))
}