package com.oliferov.test_for_reshenie_soft.data.network.dto

import com.google.gson.annotations.Expose

data class NewsDto(
    @Expose
    val userId: Int,
    @Expose
    val id: Int,
    @Expose
    val title: String,
    @Expose
    val body: String
)