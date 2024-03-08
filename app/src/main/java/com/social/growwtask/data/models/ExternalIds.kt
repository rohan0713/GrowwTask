package com.social.growwtask.data.models

import androidx.room.Entity
import java.io.Serializable

@Entity
data class ExternalIds(
    val isrc: String
) : Serializable