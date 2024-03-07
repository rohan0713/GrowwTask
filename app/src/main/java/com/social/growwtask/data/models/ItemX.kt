package com.social.growwtask.data.models

data class ItemX(
    val collaborative: Boolean,
    val description: String,
    val external_urls: ExternalUrlsX,
    val href: String,
    val id: String,
    val images: List<Image>,
    val name: String,
    val owner: Owner,
    val primary_color: Any,
    val `public`: Any,
    val snapshot_id: String,
    val tracks: Tracks,
    val type: String,
    val uri: String
)