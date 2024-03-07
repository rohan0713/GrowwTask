package com.social.growwtask.data.models

data class Playlists(
    val href: String,
    val items: List<ItemX>,
    val limit: Int,
    val next: String,
    val offset: Int,
    val previous: Any,
    val total: Int
)