package com.oliferov.test_for_reshenie_soft.presentation.screen.listnews

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.oliferov.test_for_reshenie_soft.domain.GetAllUserNewsUseCase
import com.oliferov.test_for_reshenie_soft.domain.model.News
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class NewsListViewModel @Inject constructor(
    private val getAllUserNewsUseCase: GetAllUserNewsUseCase,
) : ViewModel() {
    private val _listNews = MutableLiveData<List<News>>()
    val listNews: LiveData<List<News>>
        get() = _listNews

    fun getAllNews(uid: Int){
        viewModelScope.launch(Dispatchers.IO) {
            _listNews.postValue(getAllUserNewsUseCase(uid))
        }
    }
}