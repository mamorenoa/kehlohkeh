package com.equinox.kehlokeeh

import com.equinox.kehlokeeh.model.Location
import com.equinox.kehlokeeh.model.Place

val locGranada = Location(
    lat = 37.17830806942772,
    lng = -3.612883695290526
)

val locValencia = Location(
    lat = 39.453200065909485,
    lng = -0.355650966794391
)

val locMadrid = Location(
    lat = 40.3135142,
    lng = -3.8547616
)

val locBarcelona = Location(
    lat = 41.40730219978575,
    lng = -2.177793793374648
)

val madrid = Place(
    name = "Mercadona Móstoles",
    address = "Calle Moreleja de Enmedio",
    location = locMadrid
)

val valencia = Place(
    name = "Carrefour Valencia",
    address = "Av. del Professor López Piñero, 16, 46013 València, Valencia",
    location = locValencia
)

val granada = Place(
    name = "Hipercor Granada",
    address = "Centro Comercial Arabial, Arabial, 97, 18003 Granada",
    location = locGranada
)

val barcelona = Place(
    name = "Aldi Barcelona",
    address = "C/ de Mallorca, 458, 1a, 08013 Barcelona",
    location = locBarcelona
)

val places = listOf(
    madrid,
    valencia,
    granada,
    barcelona
)
