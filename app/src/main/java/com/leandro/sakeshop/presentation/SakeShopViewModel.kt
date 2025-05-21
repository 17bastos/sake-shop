package com.leandro.sakeshop.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.leandro.sakeshop.domain.model.SakeShop
import com.leandro.sakeshop.domain.usecase.GetSakeShopsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SakeShopViewModel @Inject constructor(
    private val getSakeShopsUseCase: GetSakeShopsUseCase
) : ViewModel() {

    private val _sakeShops = MutableStateFlow<List<SakeShop>>(emptyList())
    val sakeShops: StateFlow<List<SakeShop>> get() = _sakeShops

    init {
        viewModelScope.launch {
            _sakeShops.value = getSakeShopsUseCase()
        }
    }
}
