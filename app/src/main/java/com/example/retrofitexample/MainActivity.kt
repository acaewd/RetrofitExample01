package com.example.retrofitexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.*
import kotlin.collections.HashMap

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var userId01 = findViewById<TextView>(R.id.txtUserId)
        var id01 = findViewById<TextView>(R.id.txtId)
        var body01 = findViewById<TextView>(R.id.txtBody)
        var title01 = findViewById<TextView>(R.id.txtTitle)

        val retrofit = Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val service = retrofit.create(RetrofitService::class.java)

        val call: Call<UserInfo> = service.getUserRequest()


        call.enqueue(object : Callback<UserInfo>{

            override fun onResponse(call: Call<UserInfo>, response: Response<UserInfo>) {
                if(response.body()!=null){
                    Toast.makeText(applicationContext,"성공", Toast.LENGTH_SHORT).show()
                    userId01.text = response.body()!!.userId.toString()
                    id01.text = response.body()!!.id.toString()
                    body01.text = response.body()!!.body
                    title01.text = response.body()!!.title

                }
            }

            override fun onFailure(call: Call<UserInfo>, t: Throwable) {
                Toast.makeText(applicationContext,"실패",Toast.LENGTH_SHORT).show()
            }
        })



    }
}