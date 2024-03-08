package com.social.growwtask.data.models

import androidx.room.Entity
import java.io.Serializable

@Entity
data class Owner(
    val display_name: String,
    val external_urls: ExternalUrlsX,
    val href: String,
    val id: String,
    val type: String,
    val uri: String
) : Serializable