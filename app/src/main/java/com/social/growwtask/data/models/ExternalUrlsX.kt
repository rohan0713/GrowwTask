package com.social.growwtask.data.models

import androidx.room.Entity
import java.io.Serializable

@Entity
data class ExternalUrlsX(
    val spotify: String
) : Serializable