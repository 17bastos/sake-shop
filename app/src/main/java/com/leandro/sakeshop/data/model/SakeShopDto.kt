package com.leandro.sakeshop.data.model

import com.google.gson.annotations.SerializedName
data class SakeShopDto(
    @SerializedName("name")
    val name: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("picture")
    val picture: String?,
    @SerializedName("rating")
    val rating: Float,
    @SerializedName("address")
    val address: String,
    @SerializedName("coordinates")
    val coordinates: List<Double>,
    @SerializedName("google_maps_link")
    val googleMapsLink: String,
    @SerializedName("website")
    val website: String
)
