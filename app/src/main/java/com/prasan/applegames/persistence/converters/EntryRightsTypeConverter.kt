package com.prasan.applegames.persistence.converters

import androidx.room.TypeConverter
import com.prasan.applegames.model.GameResponse
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi

class EntryRightsTypeConverter {
    private val moshi = Moshi.Builder().build()

    @TypeConverter
    fun fromString(value: String?): GameResponse.Rights? {
        val adapter: JsonAdapter<GameResponse.Rights> = moshi.adapter(GameResponse.Rights::class.java)
        return adapter.fromJson(value)
    }

    @TypeConverter
    fun fromInfoType(type: GameResponse.Rights?): String? {
        val adapter: JsonAdapter<GameResponse.Rights> = moshi.adapter(GameResponse.Rights::class.java)
        return adapter.toJson(type)
    }
}