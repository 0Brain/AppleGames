package com.prasan.applegames.persistence.converters

import androidx.room.TypeConverter
import com.prasan.applegames.model.GameResponse
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi

class EntryNameEntryTypeConverter {

    private val moshi = Moshi.Builder().build()

    @TypeConverter
    fun fromString(value: String): GameResponse.NameEntry? {
        val adapter: JsonAdapter<GameResponse.NameEntry> = moshi.adapter(GameResponse.NameEntry::class.java)
        return adapter.fromJson(value)
    }

    @TypeConverter
    fun fromInfoType(type: GameResponse.NameEntry): String {
        val adapter: JsonAdapter<GameResponse.NameEntry> = moshi.adapter(GameResponse.NameEntry::class.java)
        return adapter.toJson(type)
    }
}