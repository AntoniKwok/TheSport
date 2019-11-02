package com.antoni.wijaya.thesport.model.league

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class LeagueDummyEntity(
    var id: String,
    var name: String,
    var image: Int
) : Parcelable
