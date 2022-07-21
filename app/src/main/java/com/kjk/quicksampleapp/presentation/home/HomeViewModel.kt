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

    init {
        Log.d(TAG, ": ")
        loadAllBooks()
    }

    private fun loadAllBooks() {
        viewModelScope.launch {
            try {
                _bookList.value = repository.getBookListFromRemote()
            } catch (e: Exception) {
                Log.d(TAG, "loadAllBooks: ${e.message}")
            }
        }
    }

    companion object {
        private const val TAG = "HomeViewModel"
    }
}