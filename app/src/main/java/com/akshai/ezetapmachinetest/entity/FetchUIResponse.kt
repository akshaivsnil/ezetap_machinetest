package com.akshai.ezetapmachinetest.entity


import com.google.gson.annotations.SerializedName

data class UiDataItem(
    @SerializedName("uitype")
    val uitype: String = "",
    @SerializedName("value")
    val value: String = "",
    @SerializedName("key")
    val key: String = "",
    @SerializedName("hint")
    val hint: String = ""
)


data class FetchUIResponse(
    @SerializedName("uidata")
    val uidata: List<UiDataItem>? = null,
    @SerializedName("logo-url")
    val logoUrl: String = "",
    @SerializedName("heading-text")
    val headingText: String = ""
)


