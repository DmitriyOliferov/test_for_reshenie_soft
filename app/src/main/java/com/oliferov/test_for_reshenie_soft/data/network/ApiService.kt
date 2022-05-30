package com.oliferov.test_for_reshenie_soft.data.network

import com.oliferov.test_for_reshenie_soft.data.network.dto.NewsDto
import com.oliferov.test_for_reshenie_soft.data.network.dto.UserDto
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("users")
    suspend fun getAllUsers(): Response<List<UserDto>>

    @GET("posts")
    suspend fun getAllUserNews(): Response<List<NewsDto>>
}
