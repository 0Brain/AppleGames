package com.prasan.applegames.persistence.converters

import androidx.room.TypeConverter
import com.prasan.applegames.model.GameResponse
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi

class EntryAttributesReleaseTypeConverter {
    private val moshi = Moshi.Builder().build()

    @TypeConverter
    fun fromString(value: String): GameResponse.AttributesRelease? {
        val adapter: JsonAdapter<GameResponse.AttributesRelease> = moshi.adapter(GameResponse.AttributesRelease::class.java)
        return adapter.fromJson(value)
    }

    @TypeConverter
    fun fromInfoType(type: GameResponse.AttributesRelease): String {
        val adapter: JsonAdapter<GameResponse.AttributesRelease> = moshi.adapter(GameResponse.AttributesRelease::class.java)
        return adapter.toJson(type)
    }
}