package com.prasan.applegames.persistence

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.prasan.applegames.model.GameResponse
import com.prasan.applegames.persistence.converters.*

@Database(entities = [GameResponse.Entry::class],version = 1,exportSchema = false)
@TypeConverters(value = [
    EntryNameEntryTypeConverter::class,
    EntryRightsTypeConverter::class,
    EntryImageTypeConverter::class,
    EntryArtistTypeConverter::class,
    EntryTitleTypeConverter::class,
    EntryIconTypeConverter::class,
    EntryPriceTypeConverter::class,
    EntryAttributesPriceTypeConverter::class,
    EntryContentTypeTypeConverter::class,
    EntryAttributesContentTypeTypeConverter::class,
    EntryCategoryTypeConverter::class,
    EntryAttributesCategoryTypeConverter::class,
    EntryReleaseDateTypeConverter::class,
    EntryAttributesReleaseTypeConverter::class,
    EntryLinkTypeConverter::class,
    EntryAttributesLinkTypeConverter::class,
    EntryIdTypeConverter::class])
abstract class EntryDatabase: RoomDatabase() {
    abstract fun entryDao():EntryDao
}