package com.kjk.quicksampleapp.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.kjk.quicksampleapp.R
import com.kjk.quicksampleapp.databinding.ListItemBookBinding
import com.kjk.quicksampleapp.domain.entity.BookEntity

class BookAdapter : RecyclerView.Adapter<BookAdapter.BookViewHolder>() {

    private var bookList = emptyList<BookEntity>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder {
        return BookViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: BookViewHolder, position: Int) {
        holder.bind(bookList[position])
    }

    override fun getItemCount(): Int {
        return bookList.size
    }

    fun updateList(bookList: List<BookEntity>) {
        this.bookList = bookList
        notifyDataSetChanged()
    }


    class BookViewHolder(
        private val binding: ListItemBookBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(bookEntity: BookEntity) {
            binding.apply {
                book = bookEntity
                executePendingBindings()
            }
        }

        companion object {
            fun from(parent: ViewGroup): BookViewHolder {
                val inflater = LayoutInflater.from(parent.context)
                val binding = DataBindingUtil.inflate<ListItemBookBinding>(
                    inflater,
                    R.layout.list_item_book,
                    parent,
                    false
                )
                return BookViewHolder(binding)
            }
        }
    }
}