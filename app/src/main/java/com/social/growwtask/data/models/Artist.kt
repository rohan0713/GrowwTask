package com.social.growwtask.data.models

import androidx.room.Entity
import java.io.Serializable

@Entity
data class Artist(
    val external_urls: ExternalUrlsX,
    val href: String,
    val id: String,
    val name: String,
    val type: String,
    val uri: String
) : Serializable