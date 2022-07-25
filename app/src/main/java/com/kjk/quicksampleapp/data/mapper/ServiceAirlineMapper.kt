package com.kjk.quicksampleapp.data.mapper

import com.kjk.quicksampleapp.data.remote.response.ServiceAirlineResponse
import com.kjk.quicksampleapp.data.remote.response.ServiceAirlinesResponse
import com.kjk.quicksampleapp.domain.entity.ServiceAirlineEntity

fun List<ServiceAirlineResponse>.toServiceAirlineEntity(): List<ServiceAirlineEntity> {
    return map {
        ServiceAirlineEntity(
            airlineName = it.airlineName,
            airlineImage = it.airlineImage,
            airlineAirportTel = it.airlineAirportTel,
            airlineOriginTel = it.airlineOriginTel,
            airlineIataCode = it.airlineIataCode,
            airlineIcaoCode = it.airlineIcaoCode
        )
    }
}