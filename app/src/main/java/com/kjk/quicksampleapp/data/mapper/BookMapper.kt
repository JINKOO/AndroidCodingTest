package com.kjk.quicksampleapp.data.mapper

import com.kjk.quicksampleapp.data.remote.response.BookResponse
import com.kjk.quicksampleapp.data.remote.response.VideoInfo
import com.kjk.quicksampleapp.domain.entity.BookEntity
import com.kjk.quicksampleapp.domain.entity.VideoEntity

fun List<VideoInfo>.toVideoEntity(): List<VideoEntity> {
    return map {
        VideoEntity(
            title = it.title,
            description = it.description,
            url = it.url,
            updated = it.updated,
            thumbnail = it.thumbnail,
            closedCaptions = it.closedCaptions
        )
    }
}

fun List<BookResponse>.toBookEntity(): List<BookEntity> {
    return map {
        BookEntity(
            number = it.number,
            title = it.title,
            author = it.authorName,
            library = it.library
        )
    }
}