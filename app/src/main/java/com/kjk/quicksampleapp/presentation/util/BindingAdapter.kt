package com.kjk.quicksampleapp.presentation.util

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.kjk.quicksampleapp.domain.entity.BookEntity
import com.kjk.quicksampleapp.presentation.adapter.BookAdapter

@BindingAdapter("bookList")
fun setBookList(recyclerView: RecyclerView, bookList: List<BookEntity>?) {
    val adapter = recyclerView.adapter as BookAdapter
    bookList?.let {
        adapter.updateList(bookList)
    }
}