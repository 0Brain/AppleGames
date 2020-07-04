package com.prasan.applegames.persistence.converters

import androidx.room.TypeConverter
import androidx.room.TypeConverters
import com.prasan.applegames.model.Entry
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi

class EntryIMPriceTypeConverter {


    private val moshi:Moshi by lazy {
        Moshi.Builder().build()
    }

    @TypeConverter
    fun IMPriceToString(value:Entry.IMPrice):String{
        val adapter = moshi.adapter(Entry.IMPrice::class.java)
        return adapter.toJson(value)
    }

    @TypeConverter
    fun StringToIMPrice(value:String):Entry.IMPrice?{
        val adapter: JsonAdapter<Entry.IMPrice> = moshi.adapter(Entry.IMPrice::class.java)
        return adapter.fromJson(value)
    }
}