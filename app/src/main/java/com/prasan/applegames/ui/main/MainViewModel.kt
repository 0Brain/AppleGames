package com.prasan.applegames.ui.main

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.prasan.applegames.model.GameResponse
import com.prasan.applegames.repository.MainRepository


class MainViewModel @ViewModelInject constructor(
    private val mainRepository: MainRepository
) : ViewModel() {

    fun getAllEntries():LiveData<List<GameResponse.Entry>>{
       return mainRepository.getEntryList()
    }
}