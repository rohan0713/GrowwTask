package com.social.growwtask.data.local.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.social.growwtask.data.local.room.typeconverters.ResponseTypeConverter
import com.social.growwtask.data.local.room.typeconverters.AlbumTypeConverters
import com.social.growwtask.data.local.room.typeconverters.ArtistTypeConverters
import com.social.growwtask.data.local.room.typeconverters.PlaylistTypeConverters
import com.social.growwtask.data.local.room.typeconverters.TracksTypeConverters
import com.social.growwtask.data.models.ApiResponse

@Entity(tableName = "trackInfo")
@TypeConverters(
    ResponseTypeConverter::class,
    AlbumTypeConverters::class,
    ArtistTypeConverters::class,
    PlaylistTypeConverters::class,
    TracksTypeConverters::class)
data class TrackData(
    @PrimaryKey
    val title: String,
    val response: ApiResponse
)
