package com.magednan.wallpaperapp.data.dtos

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SearchResult(
    @SerialName("results")
    val images: List<UnsplashImage>,
)