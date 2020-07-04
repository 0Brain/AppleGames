package com.prasan.applegames.repository

import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.prasan.applegames.MyApplication
import com.prasan.applegames.model.Entry
import com.prasan.applegames.model.Start
import com.prasan.applegames.network.FeedService
import com.prasan.applegames.persistence.EntryDao
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import timber.log.Timber
import javax.inject.Inject

class MainRepository @Inject constructor(
    private val entryDao: EntryDao,
    private val feedService: FeedService
) {

    fun getEntryList():LiveData<List<Entry>>{
        val liveData = MutableLiveData<List<Entry>>()
        val entryList = entryDao.getEntryList()
        if(entryList.isEmpty()){
            feedService.getFeedResponse().enqueue(object :Callback<Start>{
                override fun onFailure(call: Call<Start>, t: Throwable) {
                    Timber.d("$t")
                    Toast.makeText(MyApplication.getContext(), "${t.message}", Toast.LENGTH_SHORT).show()
                }

                override fun onResponse(call: Call<Start>, response: Response<Start>) {
                   val start = response.body()
                    entryDao.insertEntryList(start!!.feed.entry)
                    liveData.value = start.feed.entry
                }

            })
        }
        return liveData
    }

}