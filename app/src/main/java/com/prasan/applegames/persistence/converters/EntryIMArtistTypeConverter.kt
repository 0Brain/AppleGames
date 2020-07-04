package com.prasan.applegames.persistence.converters

import androidx.room.TypeConverter
import com.prasan.applegames.model.Entry
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi

class EntryIMArtistTypeConverter {

    private val moshi:Moshi by lazy {
        Moshi.Builder().build()
    }

    @TypeConverter
    fun fromIconToString(value: Entry.IMArtist):String?{
        val adapter: JsonAdapter<Entry.IMArtist> = moshi.adapter(Entry.IMArtist::class.java)
        return adapter.toJson(value)
    }

    @TypeConverter
    fun fromStringToIcon(value:String): Entry.IMArtist?{
        val adapter: JsonAdapter<Entry.IMArtist> = moshi.adapter(Entry.IMArtist::class.java)
        return adapter.fromJson(value)
    }
}