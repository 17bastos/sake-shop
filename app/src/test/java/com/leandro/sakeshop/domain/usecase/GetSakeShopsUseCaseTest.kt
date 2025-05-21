package com.leandro.sakeshop.domain.usecase

import com.leandro.sakeshop.domain.model.SakeShop
import com.leandro.sakeshop.domain.repository.SakeShopRepository
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.mock
import org.mockito.Mockito.`when`

class GetSakeShopsUseCaseTest {

    private lateinit var repository: SakeShopRepository
    private lateinit var useCase: GetSakeShopsUseCase

    @Before
    fun setup() {
        repository = mock()
        useCase = GetSakeShopsUseCase(repository)
    }

    @Test
    fun `should return list of shops from repository`() = runTest {
        // Arrange
        val fakeList = listOf(
            SakeShop(
                name = "Test Sake Shop",
                description = "Description",
                picture = null,
                rating = 4.5f,
                address = "Address",
                latitude = 0.0,
                longitude = 0.0,
                googleMapsLink = "http://maps.test",
                website = "http://test.com"
            )
        )

        `when`(repository.getSakeShops()).thenReturn(fakeList)

        // Act
        val result = useCase()

        // Assert
        assertEquals(1, result.size)
        assertEquals("Test Sake Shop", result.first().name)
    }
}