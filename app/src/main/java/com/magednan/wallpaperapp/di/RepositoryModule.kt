package com.magednan.wallpaperapp.di

import com.magednan.wallpaperapp.data.repositoryImpl.UnsplashRepositoryImpl
import com.magednan.wallpaperapp.domain.repository.UnsplashRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindsRepository(repositoryImpl: UnsplashRepositoryImpl):UnsplashRepository
}