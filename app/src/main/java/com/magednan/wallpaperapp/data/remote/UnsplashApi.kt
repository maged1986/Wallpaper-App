package com.magednan.wallpaperapp.data.remote

import com.magednan.wallpaperapp.data.dtos.SearchResult
import com.magednan.wallpaperapp.data.dtos.UnsplashImage
import com.magednan.wallpaperapp.utils.Resource
import kotlinx.coroutines.flow.Flow
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface UnsplashApi {

    @GET("/photos")
    suspend fun getAllImages(
        @Query("page") page: Int,
        @Query("per_page") perPage: Int
    ):List<UnsplashImage>

    @GET("/search/photos")
    suspend fun searchImages(
        @Query("query") query: String,
        @Query("per_page") perPage: Int
    ): SearchResult

}