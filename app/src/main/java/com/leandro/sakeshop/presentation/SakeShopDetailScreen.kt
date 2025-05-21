package com.leandro.sakeshop.presentation

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.leandro.sakeshop.R
import com.leandro.sakeshop.domain.model.SakeShop
import androidx.core.net.toUri

@Composable
fun SakeShopDetailScreen(shop: SakeShop) {
    val context = LocalContext.current

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Text(shop.name, style = MaterialTheme.typography.headlineSmall)
        Spacer(Modifier.height(8.dp))
        shop.picture?.let {
            AsyncImage(model = it, contentDescription = null, modifier = Modifier.fillMaxWidth().height(200.dp))
        }
        Spacer(Modifier.height(8.dp))
        Text("★ ${shop.rating}")
        Spacer(Modifier.height(8.dp))
        Text(shop.description)
        Spacer(Modifier.height(8.dp))
        Text("${stringResource(R.string.address)}: ${shop.address}", modifier = Modifier.clickable {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(shop.googleMapsLink))
            context.startActivity(intent)
        })
        Spacer(Modifier.height(8.dp))
        Text(stringResource(R.string.visit_web_site), color = MaterialTheme.colorScheme.primary, modifier = Modifier.clickable {
            val intent = Intent(Intent.ACTION_VIEW, shop.website.toUri())
            context.startActivity(intent)
        })
    }
}