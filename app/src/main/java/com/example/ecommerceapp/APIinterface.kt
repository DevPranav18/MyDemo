package com.example.ecommerceapp

import retrofit2.Call
import retrofit2.http.GET

interface APIinterface {

    @GET("products")
    fun GetProductData():Call<MyData>
}