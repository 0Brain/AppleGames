package com.prasan.applegames.persistence.converters

import androidx.room.TypeConverter
import com.prasan.applegames.model.GameResponse
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi

class EntryReleaseDateTypeConverter {
    private val moshi = Moshi.Builder().build()

    @TypeConverter
    fun fromString(value: String): GameResponse.ReleaseDate? {
        val adapter: JsonAdapter<GameResponse.ReleaseDate> = moshi.adapter(GameResponse.ReleaseDate::class.java)
        return adapter.fromJson(value)
    }

    @TypeConverter
    fun fromInfoType(type: GameResponse.ReleaseDate): String {
        val adapter: JsonAdapter<GameResponse.ReleaseDate> = moshi.adapter(GameResponse.ReleaseDate::class.java)
        return adapter.toJson(type)
    }
}