package com.prasan.applegames.persistence.converters

import androidx.room.TypeConverter
import com.prasan.applegames.model.Entry
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi

class EntryIDTypeConverter {

    private val moshi:Moshi by lazy {
        Moshi.Builder().build()
    }

    @TypeConverter
    fun fromIconToString(value: Entry.ID):String?{
        val adapter: JsonAdapter<Entry.ID> = moshi.adapter(Entry.ID::class.java)
        return adapter.toJson(value)
    }

    @TypeConverter
    fun fromStringToIcon(value:String): Entry.ID?{
        val adapter: JsonAdapter<Entry.ID> = moshi.adapter(Entry.ID::class.java)
        return adapter.fromJson(value)
    }
}