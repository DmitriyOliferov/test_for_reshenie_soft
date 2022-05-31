package com.oliferov.test_for_reshenie_soft.presentation.screen.listuser

import androidx.lifecycle.*
import com.oliferov.test_for_reshenie_soft.domain.GetAllUsersUseCase
import com.oliferov.test_for_reshenie_soft.domain.model.User
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class UsersListViewModel @Inject constructor(
    private val getAllUsersUseCase: GetAllUsersUseCase
) : ViewModel() {

    private val _listUsers = MutableLiveData<List<User>>()
    val listUsers: LiveData<List<User>>
        get() = _listUsers

    private fun getAllUsers() {
        viewModelScope.launch(Dispatchers.IO) {
            _listUsers.postValue(getAllUsersUseCase())
        }
    }

    init {
        getAllUsers()
    }
}