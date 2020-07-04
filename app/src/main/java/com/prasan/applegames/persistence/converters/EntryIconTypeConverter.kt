package com.prasan.applegames.persistence.converters

import androidx.room.TypeConverter
import com.prasan.applegames.model.Entry
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import javax.inject.Inject

class EntryIconTypeConverter {

    private val moshi = Moshi.Builder().build()

    @TypeConverter
    fun fromIconToString(value:Entry.Icon):String?{
        val adapter: JsonAdapter<Entry.Icon> = moshi.adapter(Entry.Icon::class.java)
        return adapter.toJson(value)
    }

    @TypeConverter
    fun fromStringToIcon(value:String):Entry.Icon?{
        val adapter:JsonAdapter<Entry.Icon> = moshi.adapter(Entry.Icon::class.java)
        return adapter.fromJson(value)
    }

}