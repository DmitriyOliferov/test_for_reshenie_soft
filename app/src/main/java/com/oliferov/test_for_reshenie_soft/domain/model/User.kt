package com.oliferov.test_for_reshenie_soft.domain.model

data class User(
    val id: Int,
    val name: String,
    val username: String,
    val email: String,
    val street: String,
    val suite: String,
    val city: String,
    val zipcode: String,
    val geoLat: String,
    val geoLng: String,
    val phone: String,
    val website: String,
    val companyName: String,
    val companyCatchPhrase: String,
    val companyBs: String
)
