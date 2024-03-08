package com.social.growwtask.data.local.room.typeconverters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.social.growwtask.data.models.ExternalUrlsX
import com.social.growwtask.data.models.Image
import com.social.growwtask.data.models.Owner
import com.social.growwtask.data.models.Tracks

class PlaylistTypeConverters {

    @TypeConverter
    fun fromOwner(owner: Owner): String {
        return Gson().toJson(owner)
    }

    @TypeConverter
    fun toOwner(ownerString: String): Owner {
        return Gson().fromJson(ownerString, Owner::class.java)
    }

    @TypeConverter
    fun fromTracks(tracks: Tracks): String {
        return Gson().toJson(tracks)
    }

    @TypeConverter
    fun toTracks(tracksString: String): Tracks {
        return Gson().fromJson(tracksString, Tracks::class.java)
    }
}