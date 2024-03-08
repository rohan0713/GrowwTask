package com.social.growwtask.domain.repositories

import androidx.lifecycle.LiveData
import com.social.growwtask.data.local.models.TrackData
import com.social.growwtask.data.local.room.AppDatabase
import com.social.growwtask.data.models.AlbumListResponse
import com.social.growwtask.data.models.ApiResponse
import com.social.growwtask.data.models.PlaylistResponse
import com.social.growwtask.data.remote.ApiInterface
import com.social.growwtask.data.remote.RetrofitClient
import retrofit2.Response
import javax.inject.Inject

class TrackRepository @Inject constructor(
    private val db : AppDatabase,
) : ApiInterface {

    override suspend fun getAlbums(
        song: String,
        type: String,
        token: String
    ): Response<ApiResponse> {
        return RetrofitClient.api.getAlbums(song, type, token)
    }

    override suspend fun getPlaylistTracks(id: String, token: String): Response<PlaylistResponse> {
        return RetrofitClient.api.getPlaylistTracks(id, token)
    }

    override suspend fun getAlbumTracks(id: String, token: String): Response<AlbumListResponse> {
        return RetrofitClient.api.getAlbumTracks(id, token)
    }

    suspend fun insertIntoDB(
        title: String,
        apiResponse: ApiResponse
    ) = db.getDao().upsert(TrackData(title, apiResponse))

    fun getDataFromDb() : LiveData<List<TrackData>> = db.getDao().getData()

    fun deleteFromDB(input: TrackData) = db.getDao().deleteItem(input)

}