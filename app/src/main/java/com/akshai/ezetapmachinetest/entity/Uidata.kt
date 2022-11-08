package com.akshai.ezetapmachinetest.entity


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Uidata(
    @SerialName("hint")
    val hint: String = "",
    @SerialName("key")
    val key: String= "",
    @SerialName("uitype")
    val uitype: String= "",
    @SerialName("value")
    val value: String= ""
)