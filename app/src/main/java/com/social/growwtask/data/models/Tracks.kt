package com.social.growwtask.data.models

import androidx.room.Entity
import java.io.Serializable

@Entity
data class Tracks(
    val href: String,
    val total: Int
) : Serializable