package com.leandro.sakeshop.domain.usecase

import com.leandro.sakeshop.domain.model.SakeShop
import com.leandro.sakeshop.domain.repository.SakeShopRepository

class GetSakeShopsUseCase(
    private val repository: SakeShopRepository
) {
    suspend operator fun invoke(): List<SakeShop> = repository.getSakeShops()
}
