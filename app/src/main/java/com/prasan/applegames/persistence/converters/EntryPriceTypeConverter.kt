package com.prasan.applegames.persistence.converters

import androidx.room.TypeConverter
import com.prasan.applegames.model.GameResponse
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi

class EntryPriceTypeConverter {
    private val moshi = Moshi.Builder().build()

    @TypeConverter
    fun fromString(value: String): GameResponse.Price? {
        val adapter: JsonAdapter<GameResponse.Price> = moshi.adapter(GameResponse.Price::class.java)
        return adapter.fromJson(value)
    }

    @TypeConverter
    fun fromInfoType(type: GameResponse.Price): String {
        val adapter: JsonAdapter<GameResponse.Price> = moshi.adapter(GameResponse.Price::class.java)
        return adapter.toJson(type)
    }
}