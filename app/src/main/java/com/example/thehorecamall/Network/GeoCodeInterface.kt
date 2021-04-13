package com.example.thehorecamall.Network

import CityModel
import retrofit2.Call
import retrofit2.http.GET

interface GeoCodeInterface {

    @GET("suggest.json?apiKey=0kVVNurfkAzNulnxLtZ30twz5z6ULGt2bLxirrqL1wE&query=")
    fun getGeocode() : Call<List<CityModel>>
}