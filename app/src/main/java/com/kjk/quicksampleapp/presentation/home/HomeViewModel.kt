package com.kjk.quicksampleapp.presentation.home

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kjk.quicksampleapp.data.repo.BookRepository
import com.kjk.quicksampleapp.domain.entity.BookEntity
import kotlinx.coroutines.launch
import java.lang.Exception

class HomeViewModel : ViewModel() {

    private val repository = BookRepository()

    private val _bookList = MutableLiveData<List<BookEntity>>()
    val bookList: LiveData<List<BookEntity>>
        get() = _bookList


    private val _apiStatus = MutableLiveData<ApiStatus>()
    val apiStatus: LiveData<ApiStatus>
        get() = _apiStatus

    init {
        Log.d(TAG, "init{}")
        loadAllBooks()
    }


    private fun loadAllBooks() {
        viewModelScope.launch {
            _apiStatus.value = ApiStatus.LOADING
            try {
                _bookList.value = repository.getBookListFromRemote()
                _apiStatus.value = ApiStatus.DONE
            } catch (e: Exception) {
                _apiStatus.value = ApiStatus.ERROR
                Log.d(TAG, "loadAllBooks: ${e.message}")
            }
        }
    }

    companion object {
        private const val TAG = "HomeViewModel"
    }
}

enum class ApiStatus {
    LOADING,
    DONE,
    ERROR
}