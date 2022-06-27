package com.magednan.wallpaperapp.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.magednan.wallpaperapp.data.dtos.UnsplashImage
import com.magednan.wallpaperapp.data.dtos.UnsplashRemoteKeys


@Database(entities = [UnsplashImage::class, UnsplashRemoteKeys::class], version = 1)
abstract class UnsplashDatabase : RoomDatabase() {

    abstract fun unsplashImageDao(): UnsplashImageDao
    abstract fun unsplashRemoteKeysDao(): UnsplashRemoteKeysDao

}