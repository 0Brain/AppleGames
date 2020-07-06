package com.prasan.applegames.persistence.converters

import androidx.room.TypeConverter
import com.prasan.applegames.model.GameResponse
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi

class EntryCategoryTypeConverter {
    private val moshi = Moshi.Builder().build()

    @TypeConverter
    fun fromString(value: String): GameResponse.Category? {
        val adapter: JsonAdapter<GameResponse.Category> = moshi.adapter(GameResponse.Category::class.java)
        return adapter.fromJson(value)
    }

    @TypeConverter
    fun fromInfoType(type: GameResponse.Category): String {
        val adapter: JsonAdapter<GameResponse.Category> = moshi.adapter(GameResponse.Category::class.java)
        return adapter.toJson(type)
    }
}