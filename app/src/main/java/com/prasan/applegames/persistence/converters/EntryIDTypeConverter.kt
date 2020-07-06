package com.prasan.applegames.persistence.converters

import androidx.room.TypeConverter
import com.prasan.applegames.model.GameResponse
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi

class EntryIdTypeConverter {
    private val moshi = Moshi.Builder().build()

    @TypeConverter
    fun fromString(value: String): GameResponse.Id? {
        val adapter: JsonAdapter<GameResponse.Id> = moshi.adapter(GameResponse.Id::class.java)
        return adapter.fromJson(value)
    }

    @TypeConverter
    fun fromInfoType(type: GameResponse.Id): String {
        val adapter: JsonAdapter<GameResponse.Id> = moshi.adapter(GameResponse.Id::class.java)
        return adapter.toJson(type)
    }
}