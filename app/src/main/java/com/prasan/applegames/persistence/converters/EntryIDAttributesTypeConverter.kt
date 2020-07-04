package com.prasan.applegames.persistence.converters

import androidx.room.TypeConverter
import com.prasan.applegames.model.Entry
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi

class EntryIDAttributesTypeConverter {
    private val moshi: Moshi by lazy {
        Moshi.Builder().build()
    }

    @TypeConverter
    fun fromIconToString(value: Entry.IDAttributes):String?{
        val adapter: JsonAdapter<Entry.IDAttributes> = moshi.adapter(Entry.IDAttributes::class.java)
        return adapter.toJson(value)
    }

    @TypeConverter
    fun fromStringToIcon(value:String): Entry.IDAttributes?{
        val adapter: JsonAdapter<Entry.IDAttributes> = moshi.adapter(Entry.IDAttributes::class.java)
        return adapter.fromJson(value)
    }
}