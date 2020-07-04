package com.prasan.applegames.network

import com.prasan.applegames.model.Start
import retrofit2.Call
import retrofit2.http.GET

interface FeedService {
    @GET
    fun getFeedResponse():Call<Start>
}