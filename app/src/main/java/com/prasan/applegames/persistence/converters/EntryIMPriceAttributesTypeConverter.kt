package com.prasan.applegames.persistence.converters

import androidx.room.TypeConverter
import com.prasan.applegames.model.Entry
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi

class EntryIMPriceAttributesTypeConverter {
    private val moshi: Moshi by lazy {
        Moshi.Builder().build()
    }

    @TypeConverter
    fun fromIconToString(value: Entry.IMPriceAttributes):String?{
        val adapter: JsonAdapter<Entry.IMPriceAttributes> = moshi.adapter(Entry.IMPriceAttributes::class.java)
        return adapter.toJson(value)
    }

    @TypeConverter
    fun fromStringToIcon(value:String): Entry.IMPriceAttributes?{
        val adapter: JsonAdapter<Entry.IMPriceAttributes> = moshi.adapter(Entry.IMPriceAttributes::class.java)
        return adapter.fromJson(value)
    }
}