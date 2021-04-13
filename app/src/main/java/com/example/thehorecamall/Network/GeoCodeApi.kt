package com.example.thehorecamall.Network

import com.google.gson.Gson
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class GeoCodeApi {
    var retrofit : Retrofit? = null

    fun getClient() : Retrofit{
        val okHttpClient : OkHttpClient = OkHttpClient()
        retrofit = Retrofit.Builder()
                .baseUrl("https://autocomplete.geocoder.ls.hereapi.com/6.2/")
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        return retrofit as Retrofit
    }


}