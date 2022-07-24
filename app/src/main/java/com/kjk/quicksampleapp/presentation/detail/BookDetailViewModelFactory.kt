package com.kjk.quicksampleapp.presentation.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.kjk.quicksampleapp.domain.entity.BookEntity
import java.lang.IllegalStateException

class BookDetailViewModelFactory(
    private val bookEntity: BookEntity
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(BookDetailViewModel::class.java)) {
            return BookDetailViewModel(bookEntity) as T
        }
        throw IllegalStateException("Unknown ViewModel class")
    }
}