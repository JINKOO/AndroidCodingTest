package com.kjk.quicksampleapp.data.mapper

import com.kjk.quicksampleapp.data.remote.response.VideoResponse
import com.kjk.quicksampleapp.domain.entity.VideoEntity

fun List<VideoResponse>.toVideoEntity(): List<VideoEntity> {
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