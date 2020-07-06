package com.prasan.applegames.ui.main

import android.os.Build
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.activity.viewModels
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.prasan.applegames.R
import com.prasan.applegames.model.GameResponse
import com.prasan.applegames.network.GameApi
import com.prasan.applegames.ui.adapter.GameAdapter
import dagger.hilt.android.AndroidEntryPoint
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import timber.log.Timber
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject lateinit var feedApi:GameApi
    //Lazy Initializations of final objects
    private lateinit var mRecyclerView : RecyclerView
    private lateinit var mAdapter:GameAdapter
    private lateinit var mLayoutManager : StaggeredGridLayoutManager
    //Hilt ViewModel Injection
    private val noteViewModel:MainViewModel by viewModels()
    private lateinit var menu:Menu


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mRecyclerView = findViewById<RecyclerView>(R.id.my_recycler_view)
        mLayoutManager =  StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL)
        mRecyclerView.layoutManager = mLayoutManager
        mRecyclerView.setHasFixedSize(true)
        mAdapter = GameAdapter(mLayoutManager)
        noteViewModel.getAllEntries().observe(this, Observer {
            mAdapter.setEntries(it)
            mRecyclerView.adapter = mAdapter
        })
    }

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.menu_share ->{
                if (mLayoutManager?.spanCount == 1) {
                    mLayoutManager?.spanCount = 2
                    menu.getItem(0).icon = ContextCompat.getDrawable(this,R.drawable.ic_list)

                } else {
                    mLayoutManager?.spanCount = 1
                    menu.getItem(0).icon = ContextCompat.getDrawable(this,R.drawable.ic_grid)
                }
                mAdapter?.notifyItemRangeChanged(0, mAdapter?.itemCount ?: 0)
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        this.menu = menu!!
        menuInflater.inflate(R.menu.main, menu)
        return super.onCreateOptionsMenu(menu)
    }
}