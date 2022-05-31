package com.oliferov.test_for_reshenie_soft.data.network.dto

import com.google.gson.annotations.Expose

class UserDto(
    @Expose
    val id: Int,
    @Expose
    val name: String,
    @Expose
    val username: String,
    @Expose
    val email: String,
    @Expose
    val address: UserAddressDto,
    @Expose
    val phone: String,
    @Expose
    val website: String,
    @Expose
    val company: UserCompanyDto
)