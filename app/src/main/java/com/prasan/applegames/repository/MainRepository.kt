package com.prasan.applegames.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.prasan.applegames.model.GameResponse
import com.prasan.applegames.network.GameApi
import com.prasan.applegames.persistence.EntryDao
import kotlinx.coroutines.*
import timber.log.Timber
import javax.inject.Inject

class MainRepository @Inject constructor(
    private val entryDao: EntryDao,
    private val gameApi: GameApi
) {
    fun getEntryList(): LiveData<List<GameResponse.Entry>> {
        val liveData = MutableLiveData<List<GameResponse.Entry>>()
        GlobalScope.launch(Dispatchers.IO) {
            val entryList = async(Dispatchers.IO) {
                return@async entryDao.getEntryList()
            }
            liveData.postValue(entryList.await())
        }
        if (liveData.value == null) {
            GlobalScope.launch(Dispatchers.IO) {
                val response = gameApi.getFeedResponse()
                if (response.isSuccessful) {
                    liveData.postValue(response.body()!!.feed.entry)
                }else if (!response.isSuccessful) {
                    Timber.d(response.message())
                }
            }
        } else {
            return liveData
        }
        return liveData
    }
}