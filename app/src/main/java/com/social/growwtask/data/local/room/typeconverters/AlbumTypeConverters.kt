package com.social.growwtask.data.local.room.typeconverters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.social.growwtask.data.models.Artist
import com.social.growwtask.data.models.ExternalUrlsX
import com.social.growwtask.data.models.Image

class AlbumTypeConverters {

    @TypeConverter
    fun fromList(artistList: List<Artist>): String {
        return Gson().toJson(artistList)
    }

    @TypeConverter
    fun toList(artistString: String): List<Artist> {
        val listType = object : TypeToken<List<Artist>>() {}.type
        return Gson().fromJson(artistString, listType)
    }

    @TypeConverter
    fun fromExternalUrls(externalUrls: ExternalUrlsX): String {
        return Gson().toJson(externalUrls)
    }

    @TypeConverter
    fun toExternalUrls(externalUrlsString: String): ExternalUrlsX {
        return Gson().fromJson(externalUrlsString, ExternalUrlsX::class.java)
    }

    @TypeConverter
    fun fromListImage(imageList: List<Image>): String {
        return Gson().toJson(imageList)
    }

    @TypeConverter
    fun toListImage(imageString: String): List<Image> {
        val listType = object : TypeToken<List<Image>>() {}.type
        return Gson().fromJson(imageString, listType)
    }
}