package com.social.growwtask.data.models

import androidx.room.Entity
import java.io.Serializable

@Entity
data class ArtistX (
    val href : String,
    val items: List<ArtistItemX>,
    val limit: Int,
    val next: String,
    val offset: Int,
    val previous: Any,
    val total: Int
) : Serializable