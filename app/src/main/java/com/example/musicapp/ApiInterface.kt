package com.example.musicapp

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface ApiInterface {


    @Headers("x-rapidapi-key: 893a3bbfd3msh16a2e1aba3a87f4p17692cjsn479447dea4cc","x-rapidapi-host: deezerdevs-deezer.p.rapidapi.com")
    @GET("search")
    fun getData(@Query("q")query: String): Call<MyData>

}