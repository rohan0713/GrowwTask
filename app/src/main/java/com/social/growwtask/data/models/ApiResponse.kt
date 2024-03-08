package com.social.growwtask.data.models

import androidx.room.Entity
import java.io.Serializable

@Entity
data class ApiResponse(
    val albums: Albums,
    val playlists: Playlists,
    val tracks: TracksX,
    val artists: ArtistX
) : Serializable