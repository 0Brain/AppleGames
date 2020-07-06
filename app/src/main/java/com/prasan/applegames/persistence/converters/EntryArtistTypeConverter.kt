package com.prasan.applegames.persistence.converters

import androidx.room.TypeConverter
import com.prasan.applegames.model.GameResponse
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi

class EntryArtistTypeConverter {
    private val moshi = Moshi.Builder().build()

    @TypeConverter
    fun fromString(value: String): GameResponse.Artist? {
        val adapter: JsonAdapter<GameResponse.Artist> = moshi.adapter(GameResponse.Artist::class.java)
        return adapter.fromJson(value)
    }

    @TypeConverter
    fun fromInfoType(type: GameResponse.Artist): String {
        val adapter: JsonAdapter<GameResponse.Artist> = moshi.adapter(GameResponse.Artist::class.java)
        return adapter.toJson(type)
    }
}