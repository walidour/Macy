package com.example.macy.utils

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type

class Converters {
    @TypeConverter
    fun fromProductList(products: List<Long>): String {
        return Gson().toJson(products)
    }

    @TypeConverter
    fun toProductList(json: String): List<Long> {
        val type: Type = object : TypeToken<List<Long>>() {}.type
        return Gson().fromJson(json, type)
    }
}