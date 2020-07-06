package com.prasan.applegames.di

import android.content.Context
import androidx.room.Room
import com.prasan.applegames.persistence.EntryDao
import com.prasan.applegames.persistence.EntryDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object DatabaseModule {
    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext context: Context): EntryDatabase {
        return Room.databaseBuilder(
            context.applicationContext,
            EntryDatabase::class.java,
            "game_database"
        ).fallbackToDestructiveMigration()
            .build()
    }

    @Singleton
    @Provides
    fun provideEntryDao(database: EntryDatabase): EntryDao {
        return database.entryDao()
    }
}