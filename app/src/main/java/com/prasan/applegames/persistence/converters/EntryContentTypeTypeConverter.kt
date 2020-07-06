package com.prasan.applegames.persistence.converters

import androidx.room.TypeConverter
import com.prasan.applegames.model.GameResponse
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi

class EntryContentTypeTypeConverter {
    private val moshi = Moshi.Builder().build()

    @TypeConverter
    fun fromString(value: String): GameResponse.ContentType? {
        val adapter: JsonAdapter<GameResponse.ContentType> = moshi.adapter(GameResponse.ContentType::class.java)
        return adapter.fromJson(value)
    }

    @TypeConverter
    fun fromInfoType(type: GameResponse.ContentType): String {
        val adapter: JsonAdapter<GameResponse.ContentType> = moshi.adapter(GameResponse.ContentType::class.java)
        return adapter.toJson(type)
    }
}