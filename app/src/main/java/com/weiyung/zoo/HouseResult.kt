package com.weiyung.zoo

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize

@Parcelize
data class HouseResult(
    val error: String? = null,
//    @Json(name = "data") val content: List<Content>? = null,
//    @Json(name = "next_paging") val paging: String? = null
) : Parcelable