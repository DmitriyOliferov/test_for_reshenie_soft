package com.oliferov.test_for_reshenie_soft.data.database.DbModel

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "news")
data class NewsDbModel(
    val userId: Int,
    @PrimaryKey
    val id: Int,
    val title: String,
    val body: String
)
