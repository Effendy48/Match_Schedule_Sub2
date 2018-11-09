package com.example.lenovo.footballclub.api

import android.telecom.Call
import com.example.lenovo.footballclub.BuildConfig
import com.example.lenovo.footballclub.model.NextMatch
import com.example.lenovo.footballclub.model.NextMatchResponse
import retrofit2.http.GET

interface ApiInterface {
    @GET("api/v1/json/${BuildConfig.API_KEY}/eventsnextleague.php?id=4328")
    fun getNextMatch():Call<NextMatchResponse>
}