package com.social.growwtask.data.models

import androidx.room.Entity
import java.io.Serializable

@Entity
data class Albums(
    val href: String,
    val items: List<Item>,
    val limit: Int,
    val next: String,
    val offset: Int,
    val previous: Any,
    val total: Int
) : Serializable