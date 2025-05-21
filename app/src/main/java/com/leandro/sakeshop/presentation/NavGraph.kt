package com.leandro.sakeshop.presentation

import android.net.Uri
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.google.gson.Gson
import com.leandro.sakeshop.domain.model.SakeShop

@Composable
fun AppNavGraph(navController: NavHostController) {
    val gson = Gson()

    NavHost(navController, startDestination = "list") {
        composable("list") {
            SakeShopListScreen(
                onItemClick = { shop ->
                    val shopJson = Uri.encode(gson.toJson(shop))
                    navController.navigate("detail/$shopJson")
                }
            )
        }

        composable(
            "detail/{shop}",
            arguments = listOf(navArgument("shop") { type = NavType.StringType })
        ) { backStackEntry ->
            val shopJson = backStackEntry.arguments?.getString("shop")
            val shop = gson.fromJson(shopJson, SakeShop::class.java)
            SakeShopDetailScreen(shop)
        }
    }
}
