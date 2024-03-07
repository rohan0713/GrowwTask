package com.social.growwtask.data.models

data class TracksX(
    val href: String,
    val items: List<ItemXX>,
    val limit: Int,
    val next: String,
    val offset: Int,
    val previous: Any,
    val total: Int
)