package com.oliferov.test_for_reshenie_soft.data.network.dto

import com.google.gson.annotations.Expose

data class UserGeoDto(
    @Expose
    val lat: String,
    @Expose
    val lng: String
)
