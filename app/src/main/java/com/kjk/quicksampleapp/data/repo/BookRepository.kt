package com.kjk.quicksampleapp.data.repo

import com.kjk.quicksampleapp.data.mapper.toBookEntity
import com.kjk.quicksampleapp.data.mapper.toVideoEntity
import com.kjk.quicksampleapp.data.remote.network.BookApi
import com.kjk.quicksampleapp.data.remote.network.VideoApi
import com.kjk.quicksampleapp.domain.entity.BookEntity
import com.kjk.quicksampleapp.domain.entity.VideoEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.Dispatcher

class BookRepository {

    private var bookList: List<BookEntity> = emptyList()

    suspend fun getBookListFromRemote(): List<BookEntity> {
        withContext(Dispatchers.IO) {
            bookList = BookApi.bookApiService.getBookList().items.toBookEntity()
        }
        return bookList
    }
}