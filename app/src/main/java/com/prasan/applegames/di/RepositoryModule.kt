package com.prasan.applegames.di

import com.prasan.applegames.network.GameApi
import com.prasan.applegames.persistence.EntryDao
import com.prasan.applegames.repository.MainRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton


@Module
@InstallIn(ApplicationComponent::class)
object RepositoryModule {
    @Singleton
    @Provides
    fun provideNoteRepository(entryDao: EntryDao, gameApi: GameApi): MainRepository {
        return MainRepository(entryDao,gameApi)
    }

}