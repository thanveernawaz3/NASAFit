package com.example.nasafit.ViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.nasafit.Utils.RetrofitRepository
import kotlinx.coroutines.Dispatchers

class MarsViewModel : ViewModel() {

private val retrofitRepository = RetrofitRepository()

    val data = liveData(Dispatchers.IO){
        val marsData = retrofitRepository.getData()
        emit(marsData   )
    }
}