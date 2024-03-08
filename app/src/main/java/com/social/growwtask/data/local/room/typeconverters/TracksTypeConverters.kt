package com.social.growwtask.data.local.room.typeconverters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.social.growwtask.data.models.Album
import com.social.growwtask.data.models.ExternalIds
import com.social.growwtask.data.models.ItemXX

class TracksTypeConverters {

    @TypeConverter
    fun fromItemXX(itemXX: ItemXX): String {
        return Gson().toJson(itemXX)
    }

    @TypeConverter
    fun toItemXX(itemXXString: String): ItemXX {
        return Gson().fromJson(itemXXString, ItemXX::class.java)
    }

    @TypeConverter
    fun fromItemList(itemList: List<ItemXX>): String {
        return Gson().toJson(itemList)
    }

    @TypeConverter
    fun toItemList(itemListString: String): List<ItemXX> {
        val listType = object : TypeToken<List<ItemXX>>() {}.type
        return Gson().fromJson(itemListString, listType)
    }

    @TypeConverter
    fun fromAlbum(album: Album): String {
        return Gson().toJson(album)
    }

    @TypeConverter
    fun toAlbum(albumString: String): Album {
        return Gson().fromJson(albumString, Album::class.java)
    }

    @TypeConverter
    fun fromExternalIds(externalIds: ExternalIds): String {
        return Gson().toJson(externalIds)
    }

    @TypeConverter
    fun toExternalIds(externalIdsString: String): ExternalIds {
        return Gson().fromJson(externalIdsString, ExternalIds::class.java)
    }


}