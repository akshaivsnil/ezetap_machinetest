package com.akshai.ezetapmachinetest.entity


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class UiResponse(
    @SerialName("heading-text")
    val headingText: String,
    @SerialName("logo-url")
    val logoUrl: String,
    @SerialName("uidata")
    val uidata: List<Uidata>
)