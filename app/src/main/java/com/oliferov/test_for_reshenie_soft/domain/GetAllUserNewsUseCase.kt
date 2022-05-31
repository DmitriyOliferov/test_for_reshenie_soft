package com.oliferov.test_for_reshenie_soft.domain

import javax.inject.Inject

class GetAllUserNewsUseCase @Inject constructor(private val repository: UserPostsRepository) {
    suspend operator fun invoke(uid: Int) = repository.getAllUserNews(uid)
}