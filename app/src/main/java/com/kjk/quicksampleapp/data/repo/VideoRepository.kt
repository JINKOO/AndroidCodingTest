package com.kjk.quicksampleapp.data.repo

import com.kjk.quicksampleapp.data.mapper.toVideoEntity
import com.kjk.quicksampleapp.data.remote.network.VideoApi
import com.kjk.quicksampleapp.domain.entity.VideoEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class VideoRepository {

    private var videoList: List<VideoEntity> = emptyList()

    suspend fun getVideoListFromRemote(): List<VideoEntity> {
        withContext(Dispatchers.IO) {
            videoList = VideoApi.videoApiService.getAllVideos().videos.toVideoEntity()
        }
        return videoList
    }
}