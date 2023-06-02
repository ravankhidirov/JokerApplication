package com.ravankhidirov.jokeapp.api

import com.ravankhidirov.jokeapp.model.Result
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface Api {
    @GET("joke/Any")
    fun getJoke(@Query("type") type: String): Call<Result?>?
}