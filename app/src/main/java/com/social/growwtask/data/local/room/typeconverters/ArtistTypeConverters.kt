package com.social.growwtask.data.local.room.typeconverters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.social.growwtask.data.models.ArtistItemX
import com.social.growwtask.data.models.ExternalUrlsX
import com.social.growwtask.data.models.Followers
import com.social.growwtask.data.models.Image

class ArtistTypeConverters {

    @TypeConverter
    fun fromArtistItemX(artistItemX: ArtistItemX): String {
        return Gson().toJson(artistItemX)
    }

    @TypeConverter
    fun toArtistItemX(artistItemXString: String): ArtistItemX {
        return Gson().fromJson(artistItemXString, ArtistItemX::class.java)
    }

    @TypeConverter
    fun fromArtistItemXList(artistItemXList: List<ArtistItemX>): String {
        return Gson().toJson(artistItemXList)
    }

    @TypeConverter
    fun toArtistItemXList(artistItemXListString: String): List<ArtistItemX> {
        val listType = object : TypeToken<List<ArtistItemX>>() {}.type
        return Gson().fromJson(artistItemXListString, listType)
    }

    @TypeConverter
    fun fromFollowers(followers: Followers): String {
        return Gson().toJson(followers)
    }

    @TypeConverter
    fun toFollowers(followersString: String): Followers {
        return Gson().fromJson(followersString, Followers::class.java)
    }

    @TypeConverter
    fun fromGenreList(genresList: List<String>): String {
        return Gson().toJson(genresList)
    }

    @TypeConverter
    fun toGenreList(genresString: String): List<String> {
        val listType = object : TypeToken<List<String>>() {}.type
        return Gson().fromJson(genresString, listType)
    }
}