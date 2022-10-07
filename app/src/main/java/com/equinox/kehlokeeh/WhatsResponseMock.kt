package com.equinox.kehlokeeh

import com.equinox.kehlokeeh.data.LocationResponse
import com.equinox.kehlokeeh.data.PlaceResponse
import com.equinox.kehlokeeh.data.ProductDataResponse
import com.equinox.kehlokeeh.data.RnResponse
import com.equinox.kehlokeeh.data.UserResponse
import com.equinox.kehlokeeh.data.WhatResponse

val whatsMilkResponse = WhatResponse(
    user = UserResponse("1"),
    rn = RnResponse(
        id = "1500047/S",
        productData = ProductDataResponse(
            enterpriseName = "ANDIA LACTEOS DE CANTABRIA, SLU",
            dateRegistering = "21/05/1977",
            address = "BARRIO SAN ANTONIO NºS/N",
            city = "RENEDO",
            province = "Cantabria",
            socialAddress = "BARRIO SAN ANTONIO NºS/N - RENEDO - 39470 - Cantabria",
            activities = listOf(
                "Fabricación o Elaboración o Transformación - Leche UHT y esterilizada",
                "Fabricación o Elaboración o Transformación - Leche pasterizada",
                "Fabricación o Elaboración o Transformación - Productos transformados a base de leche",
                "Fabricación o Elaboración o Transformación - Leche deshidratada parcialmente (evaporada y concentrada)"
            )
        ),
        isFavourite = false,
        places = listOf(
            PlaceResponse(
                name = "Mercadona",
                address = "Av. de la Ilustración, s/n, 18016 Granada",
                location = LocationResponse(
                    lat = 37.15090934534388,
                    lng = -3.6056559899296157
                ),
                price = 1.26
            )
        )
    )
)

val whatsAnchovesResponse = WhatResponse(
    user = UserResponse("2"),
    rn = RnResponse(
        id = "12.00528/S",
        productData = ProductDataResponse(
            enterpriseName = "CONSORCIO ESPAÑOL CONSERVERO SA",
            dateRegistering = "27/11/1981",
            address = "POLIGONO INDUSTRIAL LAS MARISMAS, Nº 61-62 NºS/N",
            city = "SANTOÑA",
            province = "Cantabria",
            socialAddress = "C/ EGUILIOR Nº1 - SANTOÑA - 39740 - Cantabria",
            activities = listOf(
                "Fabricación o Elaboración o Transformación - Semiconservas de productos de la pesca",
                "Fabricación o Elaboración o Transformación - Productos de la pesca salados y en salazón",
                "Importación - Productos de la pesca congelados",
                "Importación - Semiconservas de productos de la pesca",
                "Importación - Productos de la pesca salados y en salazón"
            )
        ),
        isFavourite = false,
        places = listOf(
            PlaceResponse(
                name = "Carrefour",
                address = "Ctra. de Armilla, s/n, 18006 Granada",
                location = LocationResponse(
                    lat = 37.154839321109286,
                    lng = -3.6081525600603217
                ),
                price = 2.69
            )
        )
    )
)

val whatsResponses = listOf(
    whatsAnchovesResponse,
    whatsMilkResponse
)
