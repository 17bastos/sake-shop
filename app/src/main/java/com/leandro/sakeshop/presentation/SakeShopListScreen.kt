package com.leandro.sakeshop.presentation

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.leandro.sakeshop.domain.model.SakeShop

@Composable
fun SakeShopListScreen(
    onItemClick: (SakeShop) -> Unit,
    viewModel: SakeShopViewModel = hiltViewModel()
) {
    val shops by viewModel.sakeShops.collectAsState(emptyList())

    LazyColumn(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        items(shops.size) { i ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
                    .clickable { onItemClick(shops[i]) }
            ) {
                Column(Modifier.padding(16.dp)) {
                    Text(shops[i].name, style = MaterialTheme.typography.titleMedium)
                    Text(shops[i].address, style = MaterialTheme.typography.bodySmall)
                    Text("★ ${shops[i].rating}", style = MaterialTheme.typography.bodySmall)
                }
            }
        }
    }
}