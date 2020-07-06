package com.prasan.applegames.persistence.converters

import androidx.room.TypeConverter
import com.prasan.applegames.model.GameResponse
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi

class EntryTitleTypeConverter {
    private val moshi = Moshi.Builder().build()

    @TypeConverter
    fun fromString(value: String): GameResponse.Title? {
        val adapter: JsonAdapter<GameResponse.Title> = moshi.adapter(GameResponse.Title::class.java)
        return adapter.fromJson(value)
    }

    @TypeConverter
    fun fromInfoType(type: GameResponse.Title): String {
        val adapter: JsonAdapter<GameResponse.Title> = moshi.adapter(GameResponse.Title::class.java)
        return adapter.toJson(type)
    }
}