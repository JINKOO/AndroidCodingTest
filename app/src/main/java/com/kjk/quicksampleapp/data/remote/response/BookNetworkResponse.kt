package com.kjk.quicksampleapp.data.remote.response

import com.google.gson.annotations.SerializedName

data class BookNetworkResponse(
    val resultCode: Int,
    val resultMsg: String,
    val numOfRows: Int,
    val pageNo: Int,
    val totalCount: Int,
    @SerializedName("items")
    val items: List<BookResponse>
)

data class BookResponse(
    @SerializedName("no")     // 도서 번호
    val number: Int,
    @SerializedName("bk_nm")  // 도서명
    val title: String,
    @SerializedName("aut_nm") // 저자명
    val authorName: String,
    @SerializedName("pbl_shr") // 출판사
    val publisher: String,
    @SerializedName("pblcn_yr") // 출판년도
    val publishedYear: String,
    @SerializedName("callno") // 청구기호
    val callCode: String,
    @SerializedName("lib")    // 도서를 가지고 있는 도서관
    val library: String,
    @SerializedName("refrm")  // 도서관 내 도서를 가지고 있는 자료실
    val referenceRoom: String,
    @SerializedName("loan_yn") // 대출 가능 여부
    val loanableState: String,
    @SerializedName("rtn_ed") // 반납 예정일
    val expectedReturnDate: String,
    @SerializedName("bk_rsvt") // 도서 예약
    val bookReservation: String,
    @SerializedName("mutl_loan") // 상호 대차 여부
    val mutualLoanState: String
)
