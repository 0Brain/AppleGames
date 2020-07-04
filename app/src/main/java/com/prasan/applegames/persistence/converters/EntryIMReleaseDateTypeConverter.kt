package com.prasan.applegames.persistence.converters

import androidx.room.TypeConverter
import com.prasan.applegames.model.Entry
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi

class EntryIMReleaseDateTypeConverter {

    private val moshi:Moshi by lazy {
        Moshi.Builder().build()
    }

    @TypeConverter
    fun fromIconToString(value: Entry.IMReleaseDate):String?{
        val adapter: JsonAdapter<Entry.IMReleaseDate> = moshi.adapter(Entry.IMReleaseDate::class.java)
        return adapter.toJson(value)
    }

    @TypeConverter
    fun fromStringToIcon(value:String): Entry.IMReleaseDate?{
        val adapter: JsonAdapter<Entry.IMReleaseDate> = moshi.adapter(Entry.IMReleaseDate::class.java)
        return adapter.fromJson(value)
    }
}