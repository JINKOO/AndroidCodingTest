package com.kjk.quicksampleapp.data.repo

import com.kjk.quicksampleapp.data.mapper.toArrivalEntity
import com.kjk.quicksampleapp.data.mapper.toServiceAirlineEntity
import com.kjk.quicksampleapp.data.remote.network.IncheonAirportApi
import com.kjk.quicksampleapp.domain.entity.ArrivalEntity
import com.kjk.quicksampleapp.domain.entity.ServiceAirlineEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class IncheonAirportRepository {

    private var serviceAirlines: List<ServiceAirlineEntity> = emptyList()
    private var arrivals: List<ArrivalEntity> = emptyList()

    suspend fun getServiceAirlines(): List<ServiceAirlineEntity> {
        withContext(Dispatchers.IO) {
            serviceAirlines = IncheonAirportApi.incheonAirportApiService
                .getServiceAirlines()
                .response
                .body
                .items.toServiceAirlineEntity()
        }
        return serviceAirlines
    }

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