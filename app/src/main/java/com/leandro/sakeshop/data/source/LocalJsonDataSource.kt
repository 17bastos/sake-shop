package com.leandro.sakeshop.data.source

import android.content.Context
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.leandro.sakeshop.data.model.SakeShopDto

class LocalJsonDataSource(private val context: Context) {

    fun loadShops(): List<SakeShopDto> {
        val json = context.assets.open("sakeshop.json").bufferedReader().use { it.readText() }
        val gson = Gson()
        val type = object : TypeToken<List<SakeShopDto>>() {}.type
        return gson.fromJson(json, type)
    }
}