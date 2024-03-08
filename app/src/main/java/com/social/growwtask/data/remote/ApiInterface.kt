package com.social.growwtask.data.remote

import com.social.growwtask.data.models.AlbumListResponse
import com.social.growwtask.data.models.ApiResponse
import com.social.growwtask.data.models.PlaylistResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiInterface {

    @GET("search")
    suspend fun getAlbums(@Query("q") song : String,
                          @Query("type") type: String,
                          @Header("Authorization") token: String) : Response<ApiResponse>

    @GET("playlists/{id}/tracks")
    suspend fun getPlaylistTracks(@Path("id") id : String,
                                  @Header("Authorization") token: String) : Response<PlaylistResponse>

    @GET("albums/{id}/tracks")
    suspend fun getAlbumTracks(@Path("id") id : String,
                                  @Header("Authorization") token: String) : Response<AlbumListResponse>
}