package com.weiyung.zoo

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize

@Parcelize
data class SpeciesResult(
    val error: String? = null,
    @Json(name = "data") val animal: List<Animal>? = null,
//    @Json(name = "next_paging") val paging: String? = null
) : Parcelable