package com.oliferov.test_for_reshenie_soft.domain

class GetAllUserNewsUseCase(private val repository: UserFieldRepository) {
    operator fun invoke(uid: Int) = repository.getAllUserNews(uid)
}