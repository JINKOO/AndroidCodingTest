package com.kjk.quicksampleapp.presentation.util

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.kjk.quicksampleapp.R
import com.kjk.quicksampleapp.domain.entity.BookEntity
import com.kjk.quicksampleapp.presentation.adapter.BookAdapter

@BindingAdapter("bookList")
fun setBookList(recyclerView: RecyclerView, bookList: List<BookEntity>?) {
    val adapter = recyclerView.adapter as BookAdapter
    bookList?.let {
        adapter.updateList(bookList)
    }
}

@BindingAdapter("loabalbeBook")
fun setLoanableBook(textView: TextView, loanableState: String?) {
    loanableState?.let {
        textView.apply {
            text = if (loanableState == "Y") {
                context.getString(R.string.loanable_label)
            } else {
                context.getString(R.string.not_loanable_label)
            }
        }
    }
}