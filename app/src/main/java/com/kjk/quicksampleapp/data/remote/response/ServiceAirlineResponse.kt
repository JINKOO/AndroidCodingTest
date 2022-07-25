package com.kjk.quicksampleapp.data.remote.response

import com.google.gson.annotations.SerializedName

data class ServiceAirlinesFromNetwork(
    val response: ServiceAirlinesResponse
)

data class ServiceAirlinesResponse(
    val header: HeaderInfo,
    val body: ServiceAirlineBodyInfo
)

data class ServiceAirlineBodyInfo(
    @SerializedName("items")
    val items: List<ServiceAirlineResponse>
)

data class ServiceAirlineResponse (
    @SerializedName("airlineImage")  // "https://odp.airport.kr/apiPortal/airlineIconDown?IATA_CODE=FX"
    val airlineImage: String?,
    @SerializedName("airlineName")   // "FedEX항공"
    val airlineName: String?,
    @SerializedName("airlineTel")    // "080-023-8000", 대표 항공사 유선 번호
    val airlineOriginTel: String?,
    @SerializedName("airlineIcTel")  // "032-744-6114, 6230", 공항 내부 항공사 유선 번호
    val airlineAirportTel: String?,
    @SerializedName("airlineIata")   // "FX", 항공사 iata 코드
    val airlineIataCode: String?,
    @SerializedName("airlineIcao")   // "FDX", 항공사 icao 코드
    val airlineIcaoCode: String?
)


