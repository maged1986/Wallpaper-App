package com.magednan.wallpaperapp.data.repositoryImpl

import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.magednan.wallpaperapp.data.dtos.UnsplashImage
import com.magednan.wallpaperapp.data.local.UnsplashDatabase
import com.magednan.wallpaperapp.data.paging.SearchPagingSource
import com.magednan.wallpaperapp.data.paging.UnsplashRemoteMediator
import com.magednan.wallpaperapp.data.remote.UnsplashApi
import com.magednan.wallpaperapp.domain.repository.UnsplashRepository
import com.magednan.wallpaperapp.utils.Constants.ITEMS_PER_PAGE
import com.magednan.wallpaperapp.utils.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class UnsplashRepositoryImpl @Inject constructor(
    private val unsplashApi: UnsplashApi,
    private val unsplashDatabase: UnsplashDatabase
):UnsplashRepository {

    @ExperimentalPagingApi
    override suspend fun getAllImages(): Flow<PagingData<UnsplashImage>> {

        val pagingSourceFactory = { unsplashDatabase.unsplashImageDao().getAllImages() }
        return Pager(
            config = PagingConfig(pageSize = ITEMS_PER_PAGE),
            remoteMediator = UnsplashRemoteMediator(
                unsplashApi = unsplashApi,
                unsplashDatabase = unsplashDatabase
            ),
            pagingSourceFactory = pagingSourceFactory
        ).flow
    }

    override fun searchImages(query: String): Flow<PagingData<UnsplashImage>> {
        return Pager(
            config = PagingConfig(pageSize = ITEMS_PER_PAGE),
            pagingSourceFactory = {
                SearchPagingSource(unsplashApi = unsplashApi, query = query)
            }
        ).flow
    }
}