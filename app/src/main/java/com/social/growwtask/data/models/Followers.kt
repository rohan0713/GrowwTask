package com.social.growwtask.data.models

import androidx.room.Entity
import java.io.Serializable

@Entity
data class Followers(
    val href: Any,
    val total: Int
) : Serializable