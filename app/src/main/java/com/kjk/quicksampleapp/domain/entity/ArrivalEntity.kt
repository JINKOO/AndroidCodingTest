package com.kjk.quicksampleapp.domain.entity


data class ArrivalEntity(
    val flightId: String?,
    val operateAirline: String?,
    val operateStartTime: String?,
    val firstOperateDate: String?,
    val lastOperateDate: String?,
    val departAirportCode: String?,
    val seasonCode: String?,
    val operateOnSunday: String?,
    val operateOnMonday: String?,
    val operateOnTuesday: String?,
    val operateOnWednesday: String?,
    val operateOnThursday: String?,
    val operateOnFriday: String?,
    val operateOnSaturday: String?
)
