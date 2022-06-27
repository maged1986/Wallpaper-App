package com.magednan.wallpaperapp.presention.allLisiting

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.ExperimentalPagingApi
import androidx.paging.PagingData
import com.magednan.wallpaperapp.data.dtos.UnsplashImage
import com.magednan.wallpaperapp.data.repositoryImpl.UnsplashRepositoryImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import javax.inject.Inject

@ExperimentalPagingApi
@HiltViewModel
class AllListingViewModel  @Inject constructor(
   val repository: UnsplashRepositoryImpl
): ViewModel() {
    lateinit var getAllImages: Flow<PagingData<UnsplashImage>>
    init {
        viewModelScope.launch {
            getAllImages=repository.getAllImages()
        }
    }
}