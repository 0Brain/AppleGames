package com.prasan.applegames.persistence.converters

import androidx.room.TypeConverter
import com.prasan.applegames.model.GameResponse
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi

class EntryLinkTypeConverter {

    private val moshi = Moshi.Builder().build()

    @TypeConverter
    fun fromString(value: String): GameResponse.Link? {
        val adapter: JsonAdapter<GameResponse.Link> = moshi.adapter(GameResponse.Link::class.java)
        return adapter.fromJson(value)
    }

    @TypeConverter
    fun fromInfoType(type: GameResponse.Link): String {
        val adapter: JsonAdapter<GameResponse.Link> = moshi.adapter(GameResponse.Link::class.java)
        return adapter.toJson(type)
    }
}