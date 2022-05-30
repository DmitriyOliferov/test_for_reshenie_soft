package com.oliferov.test_for_reshenie_soft.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.oliferov.test_for_reshenie_soft.data.database.DbModel.NewsDbModel
import com.oliferov.test_for_reshenie_soft.data.database.DbModel.UserDbModel

@Dao
interface UserPostsDao {

    @Query("SELECT * FROM users ORDER BY id DESC")
    fun getAllUsers(): List<UserDbModel>

    @Query("SELECT * FROM news WHERE id == :uid")
    fun getAllUserNews(uid: Int): List<NewsDbModel>

    @Insert(entity = UserDbModel::class, onConflict = OnConflictStrategy.REPLACE)
    fun insertAllUsers(users: List<UserDbModel>)

    @Insert(entity = NewsDbModel::class, onConflict = OnConflictStrategy.REPLACE)
    fun insertAllNews(news: List<NewsDbModel>)
}
