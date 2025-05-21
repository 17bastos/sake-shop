package com.leandro.sakeshop.domain.model

data class SakeShop(
    val name: String,
    val description: String,
    val picture: String?,
    val rating: Float,
    val address: String,
    val latitude: Double,
    val longitude: Double,
    val googleMapsLink: String,
    val website: String
)