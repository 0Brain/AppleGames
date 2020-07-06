package com.prasan.applegames.network

import com.prasan.applegames.model.GameResponse
import retrofit2.Call
import retrofit2.http.GET


interface GameApi {
    @GET("/us/rss/newfreeapplications/limit=2/json")
    fun getFeedResponse(): Call<GameResponse>
}