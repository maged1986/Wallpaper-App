package com.magednan.wallpaperapp.domain.repository

import androidx.paging.PagingData
import com.magednan.wallpaperapp.data.dtos.UnsplashImage
import com.magednan.wallpaperapp.utils.Resource
import kotlinx.coroutines.flow.Flow

interface UnsplashRepository {

    suspend fun getAllImages(): Flow<PagingData<UnsplashImage>>
    fun searchImages(query: String): Flow<PagingData<UnsplashImage>>

    }