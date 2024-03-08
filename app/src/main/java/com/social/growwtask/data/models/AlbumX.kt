package com.social.growwtask.data.models

data class AlbumX(
    val album_type: String,
    val artists: List<ArtistXXX>,
    val available_markets: List<String>,
    val external_urls: ExternalUrls,
    val href: String,
    val id: String,
    val images: List<ImageX>,
    val name: String,
    val release_date: String,
    val release_date_precision: String,
    val total_tracks: Int,
    val type: String,
    val uri: String
)