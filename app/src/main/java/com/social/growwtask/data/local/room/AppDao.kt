package com.social.growwtask.data.local.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.social.growwtask.data.local.models.TrackData

@Dao
interface AppDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(trackData: TrackData) : Long

    @Query("Select * from trackInfo")
    fun getData() : LiveData<List<TrackData>>

    @Delete
    fun deleteItem(trackData: TrackData)
}