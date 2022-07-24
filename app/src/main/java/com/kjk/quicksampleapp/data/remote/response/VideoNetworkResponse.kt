package com.kjk.quicksampleapp.data.remote.response

data class VideoNetworkResponse(
    val videos: List<VideoResponse>
)

data class VideoResponse(
    val title: String,
    val description: String,
    val url: String,
    val updated: String,
    val thumbnail: String,
    val closedCaptions: String?
)