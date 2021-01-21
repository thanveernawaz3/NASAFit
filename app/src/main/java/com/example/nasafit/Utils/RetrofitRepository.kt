package com.example.nasafit.Utils

class RetrofitRepository {

    var retrofitClient : RetrofitService = RetrofitClient().retrofitService

    suspend fun getData() = retrofitClient.getMarsData()  //this function will be used in
                                                          // our ViewModel to access data from the api

}