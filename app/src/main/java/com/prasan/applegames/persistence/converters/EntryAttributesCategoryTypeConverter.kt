package com.prasan.applegames.persistence.converters

import androidx.room.TypeConverter
import com.prasan.applegames.model.GameResponse
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi

class EntryAttributesCategoryTypeConverter {
    private val moshi = Moshi.Builder().build()

    @TypeConverter
    fun fromString(value: String): GameResponse.AttributesCategory? {
        val adapter: JsonAdapter<GameResponse.AttributesCategory> = moshi.adapter(GameResponse.AttributesCategory::class.java)
        return adapter.fromJson(value)
    }

    @TypeConverter
    fun fromInfoType(type: GameResponse.AttributesCategory): String {
        val adapter: JsonAdapter<GameResponse.AttributesCategory> = moshi.adapter(GameResponse.AttributesCategory::class.java)
        return adapter.toJson(type)
    }
}