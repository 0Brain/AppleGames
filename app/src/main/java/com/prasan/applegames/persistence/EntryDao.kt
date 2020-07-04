package com.prasan.applegames.persistence

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.prasan.applegames.model.Entry


@Dao
interface EntryDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertEntryList(entryList:List<Entry>)

    @Query("SELECT * FROM Entry")
    fun getEntryList():LiveData<List<Entry>>

}