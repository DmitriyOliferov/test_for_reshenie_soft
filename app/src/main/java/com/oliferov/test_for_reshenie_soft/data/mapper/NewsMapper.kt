package com.oliferov.test_for_reshenie_soft.data.mapper

import com.oliferov.test_for_reshenie_soft.data.database.DbModel.NewsDbModel
import com.oliferov.test_for_reshenie_soft.data.network.dto.NewsDto
import com.oliferov.test_for_reshenie_soft.domain.model.News

class NewsMapper {
    fun mapNewsDtoToNewsDbModel(newsDto: NewsDto): NewsDbModel{
        with(newsDto) {
            return NewsDbModel(userId, id, title, body)
        }
    }

    fun mapNewsDbModelToNewsModel(newsDbModel: NewsDbModel): News{
        with(newsDbModel) {
            return News(userId, id, title, body)
        }
    }
}