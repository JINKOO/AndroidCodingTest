package com.kjk.quicksampleapp.data.repo

import com.kjk.quicksampleapp.data.mapper.toBookEntity
import com.kjk.quicksampleapp.data.remote.network.BookApi
import com.kjk.quicksampleapp.domain.entity.BookEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class BookRepository {

    private lateinit var bookList: List<BookEntity>

    suspend fun getBookListFromRemote(): List<BookEntity> {
        withContext(Dispatchers.IO) {
            bookList = BookApi.bookApiService.getBookList().items.toBookEntity()
        }
        return bookList
    }
}