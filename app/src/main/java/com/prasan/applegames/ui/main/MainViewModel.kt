package com.prasan.applegames.ui.main

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import com.prasan.applegames.model.Entry
import com.prasan.applegames.repository.MainRepository

class MainViewModel @ViewModelInject constructor(
    private val mainRepository: MainRepository
){

    fun getEntryList():LiveData<List<Entry>>{
        return mainRepository.getEntryList()
    }
}