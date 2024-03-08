package com.social.growwtask.data.models

data class AlbumListResponse(
    val href: String,
    val items: List<AlbumListItem>,
    val limit: Int,
    val next: String,
    val offset: Int,
    val previous: Any,
    val total: Int
)
