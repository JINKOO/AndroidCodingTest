package com.kjk.quicksampleapp.presentation.home

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kjk.quicksampleapp.data.repo.BookRepository
import com.kjk.quicksampleapp.data.repo.VideoRepository
import com.kjk.quicksampleapp.domain.entity.BookEntity
import com.kjk.quicksampleapp.domain.entity.VideoEntity
import kotlinx.coroutines.launch
import java.lang.Exception

class HomeViewModel : ViewModel() {

    private val bookRepository = BookRepository()
    private val videoRepository = VideoRepository()

    private val _bookList = MutableLiveData<List<BookEntity>>()
    val bookList: LiveData<List<BookEntity>>
        get() = _bookList


    private val _videoList = MutableLiveData<List<VideoEntity>>()
    val videoList: LiveData<List<VideoEntity>>
        get() = _videoList


    private val _apiStatus = MutableLiveData<ApiStatus>()
    val apiStatus: LiveData<ApiStatus>
        get() = _apiStatus


    private val _navigateToDetail = MutableLiveData<BookEntity?>()
    val navigateToDetail: LiveData<BookEntity?>
        get() = _navigateToDetail

    init {
        Log.d(TAG, "init{}")
        loadAllBooks()
        loadAllVideos()
    }

    private fun loadAllVideos() {
        viewModelScope.launch {
            try {
                _videoList.value = videoRepository.getVideoListFromRemote()
            } catch(e: Exception) {
                Log.d(TAG, "loadAllVideos: ${e.message}")
            }
        }
    }


    private fun loadAllBooks() {
        viewModelScope.launch {
            _apiStatus.value = ApiStatus.LOADING
            try {
                _bookList.value = bookRepository.getBookListFromRemote()
                _apiStatus.value = ApiStatus.DONE
            } catch (e: Exception) {
                _apiStatus.value = ApiStatus.ERROR
                Log.d(TAG, "loadAllBooks: ${e.message}")
            }
        }
    }

    fun navigateToDetailFragment(bookEntity: BookEntity) {
        _navigateToDetail.value = bookEntity
    }

    fun navigateToDetailDone() {
        _navigateToDetail.value = null
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