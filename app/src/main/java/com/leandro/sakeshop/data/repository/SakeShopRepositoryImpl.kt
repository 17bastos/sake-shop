package com.leandro.sakeshop.data.repository

import com.leandro.sakeshop.data.model.SakeShopDto
import com.leandro.sakeshop.data.source.LocalJsonDataSource
import com.leandro.sakeshop.domain.model.SakeShop
import com.leandro.sakeshop.domain.repository.SakeShopRepository

class SakeShopRepositoryImpl(private val dataSource: LocalJsonDataSource): SakeShopRepository {
    override suspend fun getSakeShops(): List<SakeShop> {
        return dataSource.loadShops().map { it.mapToDomain() }
    }

    private fun SakeShopDto.mapToDomain(): SakeShop {
        return SakeShop(
            name = this.name,
            description = this.description,
            picture = this.picture,
            rating = this.rating,
            address = this.address,
            latitude = this.coordinates[0],
            longitude = this.coordinates[1],
            googleMapsLink = this.googleMapsLink,
            website = this.website
        )
    }
}