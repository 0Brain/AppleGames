package com.prasan.applegames.persistence.converters

import androidx.room.TypeConverter
import com.prasan.applegames.model.GameResponse
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi

class EntryIconTypeConverter {
    private val moshi = Moshi.Builder().build()

    @TypeConverter
    fun fromString(value: String): GameResponse.Icon? {
        val adapter: JsonAdapter<GameResponse.Icon> = moshi.adapter(GameResponse.Icon::class.java)
        return adapter.fromJson(value)
    }

    @TypeConverter
    fun fromInfoType(type: GameResponse.Icon): String {
        val adapter: JsonAdapter<GameResponse.Icon> = moshi.adapter(GameResponse.Icon::class.java)
        return adapter.toJson(type)
    }
}