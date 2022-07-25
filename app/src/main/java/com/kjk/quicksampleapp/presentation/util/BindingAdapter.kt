package com.kjk.quicksampleapp.presentation.util

import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.kjk.quicksampleapp.R
import com.kjk.quicksampleapp.domain.entity.ServiceAirlineEntity
import com.kjk.quicksampleapp.presentation.adapter.AirlineAdapter
import com.kjk.quicksampleapp.presentation.home.ApiStatus

@BindingAdapter("serviceAirlineList")
fun setServiceAirlineList(recyclerView: RecyclerView, airlines: List<ServiceAirlineEntity>?) {
    val adapter = recyclerView.adapter as AirlineAdapter
    airlines?.let {
        adapter.updateList(it)
    }
}

@BindingAdapter("airlineLogo")
fun setAirlineLogo(imageView: ImageView, imageURL: String?) {
    imageURL?.let {
        Glide.with(imageView.context)
            .load(imageURL)
            .placeholder(R.drawable.ic_baseline_airplane_ticket_24)
            .into(imageView)
    }
}

@BindingAdapter("progress_visibility")
fun setProgressBar(progressBar: ProgressBar, apiStatus: ApiStatus?) {
    apiStatus?.let {
        progressBar.apply {
            visibility = when(apiStatus) {
                ApiStatus.DONE -> {
                    View.GONE
                }
                ApiStatus.ERROR -> {
                    View.GONE
                }
                ApiStatus.LOADING -> {
                    View.VISIBLE
                }
            }
        }
    }
}