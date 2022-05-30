package com.oliferov.test_for_reshenie_soft.presentation.screen.listuser

import android.app.Application
import androidx.lifecycle.*
import com.oliferov.test_for_reshenie_soft.data.database.AppDatabase
import com.oliferov.test_for_reshenie_soft.data.mapper.NewsMapper
import com.oliferov.test_for_reshenie_soft.data.mapper.UserMapper
import com.oliferov.test_for_reshenie_soft.data.network.ApiFactory
import com.oliferov.test_for_reshenie_soft.data.repository.UserPostsRepositoryImpl
import com.oliferov.test_for_reshenie_soft.domain.GetAllUsersUseCase
import com.oliferov.test_for_reshenie_soft.domain.model.User
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UsersListViewModel(
    val context: Application
) : AndroidViewModel(context) {

    private val _listUsers = MutableLiveData<List<User>>()
    val listUsers: LiveData<List<User>>
        get() = _listUsers

    private fun getAllUsers() {
        val repositoryImpl = UserPostsRepositoryImpl(
            ApiFactory.apiService,
            AppDatabase.getInstance(context).userPostsDao(),
            NewsMapper(),
            UserMapper()
        )
        val v = GetAllUsersUseCase(repositoryImpl)
        viewModelScope.launch(Dispatchers.IO) {
            _listUsers.postValue(v())
        }
    }

    init {
        getAllUsers()
    }

}