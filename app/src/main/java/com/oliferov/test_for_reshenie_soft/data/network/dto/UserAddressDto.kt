package com.oliferov.test_for_reshenie_soft.data.network.dto

import com.google.gson.annotations.Expose

data class UserAddressDto(
    @Expose
    val street: String,
    @Expose
    val suite: String,
    @Expose
    val city: String,
    @Expose
    val zipcode: String,
    @Expose
    val geo: UserGeoDto
)
