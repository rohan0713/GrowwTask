package com.social.growwtask.data.local.room

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.social.growwtask.data.local.models.TrackData
import com.social.growwtask.data.local.room.typeconverters.AlbumTypeConverters
import com.social.growwtask.data.local.room.typeconverters.ArtistTypeConverters
import com.social.growwtask.data.local.room.typeconverters.PlaylistTypeConverters
import com.social.growwtask.data.local.room.typeconverters.ResponseTypeConverter
import com.social.growwtask.data.local.room.typeconverters.TracksTypeConverters

@Database(
    entities = [TrackData::class],
    version = 3,
)
@TypeConverters(
    ResponseTypeConverter::class,
    AlbumTypeConverters::class,
    ArtistTypeConverters::class,
    PlaylistTypeConverters::class,
    TracksTypeConverters::class)
abstract class AppDatabase : RoomDatabase() {

    abstract fun getDao() : AppDao
}