package com.prasan.applegames.persistence.converters

import androidx.room.TypeConverter
import com.prasan.applegames.model.GameResponse
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi

class EntryAttributesLinkTypeConverter {

    private val moshi = Moshi.Builder().build()

    @TypeConverter
    fun fromString(value: String): GameResponse.AttributesLink? {
        val adapter: JsonAdapter<GameResponse.AttributesLink> = moshi.adapter(GameResponse.AttributesLink::class.java)
        return adapter.fromJson(value)
    }

    @TypeConverter
    fun fromInfoType(type: GameResponse.AttributesLink): String {
        val adapter: JsonAdapter<GameResponse.AttributesLink> = moshi.adapter(GameResponse.AttributesLink::class.java)
        return adapter.toJson(type)
    }
}