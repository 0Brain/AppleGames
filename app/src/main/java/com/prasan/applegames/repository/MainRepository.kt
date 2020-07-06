package com.prasan.applegames.repository

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.prasan.applegames.MyApplication
import com.prasan.applegames.model.GameResponse
import com.prasan.applegames.network.GameApi
import com.prasan.applegames.persistence.EntryDao
import kotlinx.coroutines.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import timber.log.Timber
import javax.inject.Inject

class MainRepository @Inject constructor(
    private val entryDao: EntryDao,
    private val gameApi: GameApi
) {
    fun getEntryList(): LiveData<List<GameResponse.Entry>>{
        val liveData = MutableLiveData<List<GameResponse.Entry>>()
        GlobalScope.launch(Dispatchers.Main) {
            val entryList:List<GameResponse.Entry> = async(Dispatchers.IO) {
                return@async entryDao.getEntryList()
            }.await()
            liveData.value = entryList
        }
        if (liveData.value == null) {
            gameApi.getFeedResponse().enqueue(object : Callback<GameResponse> {
                override fun onFailure(call: Call<GameResponse>, t: Throwable) {
                    Timber.d("$t")
                }

                override fun onResponse(
                    call: Call<GameResponse>,
                    response: Response<GameResponse>
                ) {
                    Timber.d("${response.body()}")
                    val gameResponse = response.body()
                    liveData.value = gameResponse!!.feed.entry
                }
            })
        }else{
              return liveData
        }
        return liveData
    }
}