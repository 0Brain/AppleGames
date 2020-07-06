package com.prasan.applegames.persistence.converters

import androidx.room.TypeConverter
import com.prasan.applegames.model.GameResponse
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types

class EntryImageTypeConverter {

    private val moshi = Moshi.Builder().build()

    @TypeConverter
    fun fromString(value: String): List<GameResponse.Image>? {
        val listType = Types.newParameterizedType(List::class.java, GameResponse.Image::class.java)
        val adapter: JsonAdapter<List<GameResponse.Image>> = moshi.adapter(listType)
        return adapter.fromJson(value)
    }

    @TypeConverter
    fun fromInfoType(type: List<GameResponse.Image>?): String {
        val listType = Types.newParameterizedType(List::class.java, GameResponse.Image::class.java)
        val adapter: JsonAdapter<List<GameResponse.Image>> = moshi.adapter(listType)
        return adapter.toJson(type)
    }
}