package com.social.growwtask.domain.repositories

import com.social.growwtask.data.models.ApiResponse
import com.social.growwtask.data.remote.ApiInterface
import com.social.growwtask.data.remote.RetrofitClient
import com.social.growwtask.utils.Constants
import retrofit2.Response

class TrackRepository : ApiInterface {

    override suspend fun getAlbums(
        song: String,
        type: String,
        token: String
    ): Response<ApiResponse> {
        return RetrofitClient.api.getAlbums(song, type, token)
    }
}