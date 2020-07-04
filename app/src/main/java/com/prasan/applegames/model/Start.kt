package com.prasan.applegames.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Start(
  @field:Json(name = "feed")val feed:Feed
){
    data class Feed(
        @field:Json(name = "entry")val entry: List<Entry>
    )
}