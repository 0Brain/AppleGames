package com.prasan.applegames.persistence

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.prasan.applegames.model.GameResponse


@Dao
interface EntryDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertEntryList(entryList:List<GameResponse.Entry>)

    @Query("SELECT * FROM Entry")
    suspend fun getEntryList():List<GameResponse.Entry>

}