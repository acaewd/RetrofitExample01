package com.example.retrofitexample

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.POST

interface RetrofitService {
    @GET("posts/1")
    fun getUserRequest() : Call<UserInfo>

}