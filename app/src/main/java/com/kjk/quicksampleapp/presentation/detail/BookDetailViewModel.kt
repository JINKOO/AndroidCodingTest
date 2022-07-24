package com.kjk.quicksampleapp.presentation.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.kjk.quicksampleapp.domain.entity.BookEntity

class BookDetailViewModel(
    bookEntity: BookEntity
) : ViewModel() {

    private val _book = MutableLiveData<BookEntity>()
    val book: LiveData<BookEntity>
        get() = _book

    init {
        _book.value = bookEntity
    }
}