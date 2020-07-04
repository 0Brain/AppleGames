package com.prasan.applegames.persistence

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.prasan.applegames.model.Entry
import com.prasan.applegames.persistence.converters.EntryIMImageTypeConverter
import com.prasan.applegames.persistence.converters.EntryIMPriceTypeConverter
import com.prasan.applegames.persistence.converters.EntryIconTypeConverter

@Database(entities = [Entry::class],version = 1)
@TypeConverters(value = [EntryIconTypeConverter::class,EntryIMImageTypeConverter::class, EntryIMPriceTypeConverter::class])
abstract class EntryDatabase: RoomDatabase() {
    abstract fun entryDao():EntryDao
}