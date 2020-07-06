package com.prasan.applegames.persistence.converters

import androidx.room.TypeConverter
import com.prasan.applegames.model.GameResponse
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi

class EntryAttributesContentTypeTypeConverter {
    private val moshi = Moshi.Builder().build()

    @TypeConverter
    fun fromString(value: String): GameResponse.AttributesContentType? {
        val adapter: JsonAdapter<GameResponse.AttributesContentType> = moshi.adapter(GameResponse.AttributesContentType::class.java)
        return adapter.fromJson(value)
    }

    @TypeConverter
    fun fromInfoType(type: GameResponse.AttributesContentType): String {
        val adapter: JsonAdapter<GameResponse.AttributesContentType> = moshi.adapter(GameResponse.AttributesContentType::class.java)
        return adapter.toJson(type)
    }
}