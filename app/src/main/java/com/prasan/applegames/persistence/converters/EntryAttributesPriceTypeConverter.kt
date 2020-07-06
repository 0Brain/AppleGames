package com.prasan.applegames.persistence.converters

import androidx.room.TypeConverter
import com.prasan.applegames.model.GameResponse
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi

class EntryAttributesPriceTypeConverter {
    private val moshi = Moshi.Builder().build()

    @TypeConverter
    fun fromString(value: String): GameResponse.AttributesPrice? {
        val adapter: JsonAdapter<GameResponse.AttributesPrice> = moshi.adapter(GameResponse.AttributesPrice::class.java)
        return adapter.fromJson(value)
    }

    @TypeConverter
    fun fromInfoType(type: GameResponse.AttributesPrice): String {
        val adapter: JsonAdapter<GameResponse.AttributesPrice> = moshi.adapter(GameResponse.AttributesPrice::class.java)
        return adapter.toJson(type)
    }
}