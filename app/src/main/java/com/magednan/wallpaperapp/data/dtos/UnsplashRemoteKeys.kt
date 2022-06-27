package com.magednan.wallpaperapp.data.dtos

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.magednan.wallpaperapp.utils.Constants.UNSPLASH_REMOTE_KEYS_TABLE


@Entity(tableName = UNSPLASH_REMOTE_KEYS_TABLE)
data class UnsplashRemoteKeys(
    @PrimaryKey(autoGenerate = false)
    val id: String,
    val prevPage: Int?,
    val nextPage: Int?
)