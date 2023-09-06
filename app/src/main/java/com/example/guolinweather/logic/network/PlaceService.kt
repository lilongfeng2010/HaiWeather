package com.example.guolinweather.logic.network

import com.example.guolinweather.SunnyWetherApplication
import com.example.guolinweather.logic.model.PlaceResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface PlaceService {

    @GET("v2/place?token=${SunnyWetherApplication.TOKEN}&lang=zh_CN")
    fun searchPlaces(@Query("query") query:String):Call<PlaceResponse>

}