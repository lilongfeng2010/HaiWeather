package com.example.guolinweather

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context

class SunnyWetherApplication : Application() {

    companion object {

        const val TOKEN = "ThnjTIFEdtVBPqXT"

        @SuppressLint("StaticFieldLeak")
        lateinit var context: Context
    }

    override fun onCreate() {
        super.onCreate()
        context = applicationContext
    }

}