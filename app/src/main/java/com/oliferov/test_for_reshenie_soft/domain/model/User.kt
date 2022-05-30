package com.oliferov.test_for_reshenie_soft.domain.model

data class User(
    val id: Int,
    val name: String,
    val username: String,
    val email: String,
    val address: UserAddress,
    val phone: String,
    val website: String,
    val company: UserCompany
)
