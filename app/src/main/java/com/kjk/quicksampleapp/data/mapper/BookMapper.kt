package com.kjk.quicksampleapp.data.mapper

import com.kjk.quicksampleapp.data.remote.response.BookResponse
import com.kjk.quicksampleapp.data.remote.response.VideoResponse
import com.kjk.quicksampleapp.domain.entity.BookEntity
import com.kjk.quicksampleapp.domain.entity.VideoEntity

fun List<BookResponse>.toBookEntity(): List<BookEntity> {
    return map {
        BookEntity(
            number = it.number,
            title = it.title,
            author = it.authorName,
            referenceLibrary = it.library,
            loanable = it.loanableState
        )
    }
}