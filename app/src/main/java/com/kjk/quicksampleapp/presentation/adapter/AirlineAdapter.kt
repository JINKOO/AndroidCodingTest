package com.kjk.quicksampleapp.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.kjk.quicksampleapp.R
import com.kjk.quicksampleapp.databinding.ListItemAirlineBinding
import com.kjk.quicksampleapp.domain.entity.ServiceAirlineEntity


class AirlineAdapter : RecyclerView.Adapter<AirlineAdapter.AirlineViewHolder>() {

    private var airlineList: List<ServiceAirlineEntity> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AirlineViewHolder {
        return AirlineViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: AirlineViewHolder, position: Int) {
        holder.bind(airlineList[position])
    }

    override fun getItemCount() = airlineList.size

    fun updateList(airlineList: List<ServiceAirlineEntity>) {
        this.airlineList = airlineList
        notifyDataSetChanged()
    }

    class AirlineViewHolder(
        private val binding: ListItemAirlineBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(serviceAirlineEntity: ServiceAirlineEntity) {
            binding.apply {
                serviceAirline = serviceAirlineEntity
                executePendingBindings()
            }
        }

        companion object {
            fun from(parent: ViewGroup): AirlineViewHolder {
                val inflater = LayoutInflater.from(parent.context)
                val binding = DataBindingUtil.inflate<ListItemAirlineBinding>(
                    inflater,
                    R.layout.list_item_airline,
                    parent,
                    false
                )
                return AirlineViewHolder(binding)
            }
        }
    }
}