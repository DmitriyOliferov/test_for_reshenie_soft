package com.oliferov.test_for_reshenie_soft.data.repository

import com.oliferov.test_for_reshenie_soft.data.database.UserPostsDao
import com.oliferov.test_for_reshenie_soft.data.mapper.NewsMapper
import com.oliferov.test_for_reshenie_soft.data.mapper.UserMapper
import com.oliferov.test_for_reshenie_soft.data.network.ApiService
import com.oliferov.test_for_reshenie_soft.domain.UserPostsRepository
import com.oliferov.test_for_reshenie_soft.domain.model.News
import com.oliferov.test_for_reshenie_soft.domain.model.User
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UserPostsRepositoryImpl(
    val apiService: ApiService,
    val dao: UserPostsDao,
    val newsMapper: NewsMapper,
    val userMapper: UserMapper
) : UserPostsRepository {

    override suspend fun getAllUsers(): List<User> {
        val listUserDto = apiService.getAllUsers().body() ?: emptyList()
        val listUserDbModel = listUserDto.map {
            userMapper.mapUserDtoToUserDbModel(it)
        }
        dao.insertAllUsers(listUserDbModel)
        val listUserModel = dao.getAllUsers().map {
            userMapper.mapUserDbModelToUserModel(it)
        }


        return listUserModel
    }

    override suspend fun getAllUserNews(uid: Int): List<News> {
        val listNewsDto = apiService.getAllUserNews().body() ?: emptyList()
        val listNewsDbModel = listNewsDto.map {
            newsMapper.mapNewsDtoToNewsDbModel(it)
        }
        dao.insertAllNews(listNewsDbModel)
        val listNewsModel = dao.getAllUserNews(uid).map {
            newsMapper.mapNewsDbModelToNewsModel(it)
        }
        return listNewsModel
    }
}