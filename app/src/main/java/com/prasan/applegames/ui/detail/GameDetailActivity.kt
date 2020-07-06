package com.prasan.applegames.ui.detail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.prasan.applegames.R
import com.prasan.applegames.model.GameResponse
import kotlinx.android.synthetic.main.activity_game_detail.*

class GameDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game_detail)

        val game: GameResponse.Entry? = intent.getParcelableExtra("gameInfo")
        val imageUrl = game!!.image[0].label
        tv_game_name.text = game.name.label
        tv_game_artist.text = game.artist.label
        tv_game_rights.text = game.rights?.label
        tv_game_release_date.text = game.releaseDate.attributes.label
        Glide.with(this).load(imageUrl).into(img_game)
    }
}