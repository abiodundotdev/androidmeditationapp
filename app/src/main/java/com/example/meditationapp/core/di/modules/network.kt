package com.example.meditationapp.core.di.modules

import com.example.meditationapp.core.constants.EndPoints
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class Network {
    companion object{
        val instance : Retrofit =   Retrofit.Builder()
            .baseUrl(EndPoints.BASEURL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();
    }
}