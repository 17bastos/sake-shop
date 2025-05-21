package com.leandro.sakeshop.domain.repository

import com.leandro.sakeshop.domain.model.SakeShop

interface SakeShopRepository {
    suspend fun getSakeShops(): List<SakeShop>
}
