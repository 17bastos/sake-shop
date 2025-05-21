package com.leandro.sakeshop.di

import android.content.Context
import com.leandro.sakeshop.data.repository.SakeShopRepositoryImpl
import com.leandro.sakeshop.data.source.LocalJsonDataSource
import com.leandro.sakeshop.domain.repository.SakeShopRepository
import com.leandro.sakeshop.domain.usecase.GetSakeShopsUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    fun provideLocalJsonDataSource(
        @ApplicationContext context: Context
    ): LocalJsonDataSource = LocalJsonDataSource(context)

    @Provides
    fun provideSakeShopRepository(
        localJsonDataSource: LocalJsonDataSource
    ): SakeShopRepository = SakeShopRepositoryImpl(localJsonDataSource)

    @Provides
    fun provideGetSakeShopsUseCase(
        repository: SakeShopRepository
    ): GetSakeShopsUseCase = GetSakeShopsUseCase(repository)
}
