package com.social.growwtask.data.models

import androidx.room.Entity
import java.io.Serializable

@Entity
data class Image(
    val height: Int,
    val url: String,
    val width: Int
) : Serializable