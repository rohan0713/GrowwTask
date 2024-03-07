package com.social.growwtask.data.remote

import com.social.growwtask.data.models.ApiResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface ApiInterface {

    @GET("search")
    suspend fun getAlbums(@Query("q") song : String,
                          @Query("type") type: String,
                          @Header("Authorization") token: String) : Response<ApiResponse>
}