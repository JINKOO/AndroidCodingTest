package com.kjk.quicksampleapp.domain.entity

data class VideoEntity(
    val title: String,
    val description: String,
    val url: String,
    val updated: String,
    val thumbnail: String,
    val closedCaptions: String?
)