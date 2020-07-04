package com.prasan.applegames.persistence

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.prasan.applegames.model.Entry
import com.prasan.applegames.persistence.converters.*

@Database(entities = [Entry::class],version = 1,exportSchema = false)
@TypeConverters(value = [EntryIconTypeConverter::class,
    EntryIMImageTypeConverter::class,
    EntryIMPriceTypeConverter::class,
    EntryIDAttributesTypeConverter::class,
    EntryIMArtistTypeConverter::class,
    EntryIDTypeConverter::class,
    EntryIMReleaseDateTypeConverter::class,
    EntryIMPriceAttributesTypeConverter::class])
abstract class EntryDatabase: RoomDatabase() {
    abstract fun entryDao():EntryDao
}