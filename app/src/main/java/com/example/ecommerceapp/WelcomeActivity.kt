package com.example.ecommerceapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class WelcomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)

        lateinit var recyclerView: RecyclerView
        lateinit var myAdapter: MyAdapter

        recyclerView= findViewById(R.id.MyrecyclerView)
        var retrofitBuilder = Retrofit.Builder()
            .baseUrl("https://dummyjson.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(APIinterface::class.java)

        var retrofitData = retrofitBuilder.GetProductData()
        retrofitData.enqueue(object : Callback<MyData?> {
            override fun onResponse(call: Call<MyData?>, response: Response<MyData?>) {
                //  Log.d("Tag: onResponse","onResponse")
                val responseBody= response.body()
                val productArray = responseBody?.products!!
                myAdapter=MyAdapter(this@WelcomeActivity,productArray)
                recyclerView.adapter=myAdapter
                recyclerView.layoutManager= LinearLayoutManager(this@WelcomeActivity)
            }

            override fun onFailure(call: Call<MyData?>, t: Throwable) {
                Log.d("Tag: onFailure", "onFailure:"+ t.message)
            }
        })
    }
}