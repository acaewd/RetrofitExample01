package com.example.retrofitexample

import retrofit2.Call
import retrofit2.http.GET

interface RetrofitService {
    @GET("posts/1")
    fun getUserRequest() : Call<UserInfo>
}