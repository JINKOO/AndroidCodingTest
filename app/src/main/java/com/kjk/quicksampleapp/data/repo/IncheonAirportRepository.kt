package com.kjk.quicksampleapp.data.repo

import com.kjk.quicksampleapp.data.mapper.toArrivalEntity
import com.kjk.quicksampleapp.data.remote.network.IncheonAirportApi
import com.kjk.quicksampleapp.domain.entity.ArrivalEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class FlightScheduleRepository {

    private var arrivals: List<ArrivalEntity> = emptyList()

    suspend fun getArrivalsFromRemote(): List<ArrivalEntity> {
        withContext(Dispatchers.IO) {
            arrivals = IncheonAirportApi
                .incheonAirportApiService
                .getFlightArrivals()
                .response.body.arrivalItems.toArrivalEntity()
        }
        return arrivals
    }
}