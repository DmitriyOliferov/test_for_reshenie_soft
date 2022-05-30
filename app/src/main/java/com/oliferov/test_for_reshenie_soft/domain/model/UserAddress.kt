package com.oliferov.test_for_reshenie_soft.domain.model

data class UserAddress(
    val street: String,
    val suite: String,
    val city: String,
    val zipcode: String,
    val geo: UserGeo
)
