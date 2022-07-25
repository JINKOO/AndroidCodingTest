package com.kjk.quicksampleapp.data.mapper

import com.kjk.quicksampleapp.data.remote.response.ArrivalResponse
import com.kjk.quicksampleapp.domain.entity.ArrivalEntity

fun List<ArrivalResponse>.toArrivalEntity(): List<ArrivalEntity> {
    return map {
        ArrivalEntity(
            flightId = it.flightId,
            operateAirline = it.operateAirline,
            operateStartTime = it.operateStartTime,
            firstOperateDate = it.firstOperateDate,
            lastOperateDate = it.lastOperateDate,
            departAirportCode = it.departAirportCode,
            seasonCode = it.seasonCode,
            operateOnSunday = it.operateOnSunday,
            operateOnMonday = it.operateOnMonday,
            operateOnTuesday = it.operateOnTuesday,
            operateOnWednesday = it.operateOnWednesday,
            operateOnThursday = it.operateOnThursday,
            operateOnFriday = it.operateOnFriday,
            operateOnSaturday = it.operateOnSaturday
        )
    }
}