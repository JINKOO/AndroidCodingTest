package com.kjk.quicksampleapp.data.remote.response

import com.google.gson.annotations.SerializedName

data class ResponseFromNetwork(
    val response: FlightArrivalResponse
)

data class FlightArrivalResponse(
    val header: HeaderInfo,
    val body: BodyInfo
)

data class HeaderInfo(
    val resultCode: String,
    val resultMessage: String
)

data class BodyInfo(
    val numOfRows: Int,
    val pageNo: Int,
    val totalCount: Int,
    @SerializedName("items")
    val arrivalItems: List<ArrivalResponse>
)

data class ArrivalResponse(
    @SerializedName("flightid")    // 편명
    val flightId: String?,
    @SerializedName("airline")     // 운항 항공사
    val operateAirline: String?,
    @SerializedName("st")          // 정기 운항 시작 시간
    val operateStartTime: String?,
    @SerializedName("firstDate")   // 정기 운항 시작일
    val firstOperateDate: String?,
    @SerializedName("lastDate")    // 정기 운항 종료일
    val lastOperateDate: String?,
    @SerializedName("airportcode") // 출발지 공항 코드 "NRT"
    val departAirportCode: String?,
    @SerializedName("season")      // 시즌명
    val seasonCode: String?,
    @SerializedName("sunday")      // 일요일 취항 여부
    val operateOnSunday: String?,
    @SerializedName("monday")      // 월요일 취항 여부
    val operateOnMonday: String?,
    @SerializedName("tuesday")     // 화요일 취항 여부
    val operateOnTuesday: String?,
    @SerializedName("wednesday")   // 수요일 취항 여부
    val operateOnWednesday: String?,
    @SerializedName("thursday")    // 목요일 취항 여부
    val operateOnThursday: String?,
    @SerializedName("Friday")      // 금요일 취항 여부
    val operateOnFriday: String?,
    @SerializedName("saturday")    // 토요일 취항 여부
    val operateOnSaturday: String?
)