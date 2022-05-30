package com.oliferov.test_for_reshenie_soft.data.network.dto

import com.google.gson.annotations.Expose

data class UserCompanyDto(
    @Expose
    val name: String,
    @Expose
    val catchPhrase: String,
    @Expose
    val bs: String
)
