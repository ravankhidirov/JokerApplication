package com.ravankhidirov.jokeapp.view_model

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ravankhidirov.jokeapp.model.Result
import com.ravankhidirov.jokeapp.network.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivityViewModel: ViewModel() {
    var joke = MutableLiveData<Result>()
    fun getJoke(context:Context)
    {
        val call: Call<Result?>? = RetrofitClient.getRetrofitInstance()?.getApi()?.getJoke("twopart")
        call?.enqueue(object:Callback<Result?>{
            override fun onResponse(call: Call<Result?>, response: Response<Result?>) {
                val joke:Result? = response.body()
                this@MainActivityViewModel.joke.postValue(joke)

            }

            override fun onFailure(call: Call<Result?>, t: Throwable) {
                Toast.makeText(context, "An error has occured", Toast.LENGTH_LONG)
                    .show()
            }

        })
    }

    fun observeJoke(): LiveData<Result>
    {
        return joke
    }
}