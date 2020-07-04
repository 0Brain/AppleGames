package com.prasan.applegames.persistence.converters

import androidx.room.TypeConverter
import com.prasan.applegames.model.Entry
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types


class EntryIMImageTypeConverter {

    private val moshi:Moshi by lazy {
        Moshi.Builder().build()
    }

    @TypeConverter
    fun fromIMImageToString(value:List<Entry.IMImage>):String{
        val listType = Types.newParameterizedType(List::class.java, Entry.IMImage::class.java)
        val adapter: JsonAdapter<List<Entry.IMImage>> = moshi.adapter(listType)
        return adapter.toJson(value)
    }

    @TypeConverter
    fun fromIMImageToString(value:String):List<Entry.IMImage>?{
        val listType = Types.newParameterizedType(List::class.java, Entry.IMImage::class.java)
        val adapter: JsonAdapter<List<Entry.IMImage>> = moshi.adapter(listType)
        return adapter.fromJson(value)
    }
}