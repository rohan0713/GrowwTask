package com.social.growwtask.data.local.room.typeconverters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.social.growwtask.data.models.Albums
import com.social.growwtask.data.models.ApiResponse
import com.social.growwtask.data.models.ArtistX
import com.social.growwtask.data.models.ItemX
import com.social.growwtask.data.models.Playlists
import com.social.growwtask.data.models.TracksX

class ResponseTypeConverter {
    @TypeConverter
    fun fromApiResponse(response: ApiResponse): String {
        // Convert ApiResponse to JSON string
        return Gson().toJson(response)
    }

    @TypeConverter
    fun toApiResponse(value: String): ApiResponse {
        // Convert JSON string to ApiResponse
        return Gson().fromJson(value, ApiResponse::class.java)
    }

    @TypeConverter
    fun fromAlbums(albums: Albums): String {
        return Gson().toJson(albums)
    }

    @TypeConverter
    fun toAlbums(value: String): Albums {
        return Gson().fromJson(value, Albums::class.java)
    }

    @TypeConverter
    fun fromPlaylists(playlists: Playlists): String {
        return Gson().toJson(playlists)
    }

    @TypeConverter
    fun toPlaylists(value: String): Playlists {
        return Gson().fromJson(value, Playlists::class.java)
    }

    @TypeConverter
    fun fromItemX(itemX: ItemX): String {
        return Gson().toJson(itemX)
    }

    @TypeConverter
    fun toItemX(itemXString: String): ItemX {
        return Gson().fromJson(itemXString, ItemX::class.java)
    }

    @TypeConverter
    fun fromItemList(itemList: List<ItemX>): String {
        return Gson().toJson(itemList)
    }

    @TypeConverter
    fun toItemList(itemListString: String): List<ItemX> {
        val listType = object : TypeToken<List<ItemX>>() {}.type
        return Gson().fromJson(itemListString, listType)
    }


    @TypeConverter
    fun fromTracksX(tracksX: TracksX): String {
        return Gson().toJson(tracksX)
    }

    @TypeConverter
    fun toTracksX(value: String): TracksX {
        return Gson().fromJson(value, TracksX::class.java)
    }

    @TypeConverter
    fun fromArtistX(artistX: ArtistX): String {
        return Gson().toJson(artistX)
    }

    @TypeConverter
    fun toArtistX(value: String): ArtistX {
        return Gson().fromJson(value, ArtistX::class.java)
    }

}