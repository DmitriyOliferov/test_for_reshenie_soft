package com.oliferov.test_for_reshenie_soft.domain

import com.oliferov.test_for_reshenie_soft.domain.model.News
import com.oliferov.test_for_reshenie_soft.domain.model.User

interface UserFieldRepository {
    suspend fun getAllUsers(): List<User>

    suspend fun getAllUserNews(uid: Int): List<News>
}