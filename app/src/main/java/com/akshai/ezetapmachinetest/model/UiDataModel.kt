package com.akshai.ezetapmachinetest.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class UiDataModel(
    var name: String = "",
    var city: String = "",
    var phone: String = "",
    var imageUrl : String = ""
) : Parcelable
