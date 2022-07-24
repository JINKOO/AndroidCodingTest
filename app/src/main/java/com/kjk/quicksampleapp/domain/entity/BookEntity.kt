package com.kjk.quicksampleapp.domain.entity

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class BookEntity(
    val number: Int,
    val title: String,
    val author: String,
    val referenceLibrary: String,
    val loanable: String?
) : Parcelable
