package com.magednan.wallpaperapp.di

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import com.magednan.wallpaperapp.data.remote.AuthInterceptor
import com.magednan.wallpaperapp.data.remote.UnsplashApi
import com.magednan.wallpaperapp.utils.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.json.Json
import okhttp3.MediaType
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RetrofitModule {

    @Provides
    @Singleton
    fun provideRetrofit():Retrofit{
        val interceptor=HttpLoggingInterceptor()
         interceptor.level=HttpLoggingInterceptor.Level.BODY
        val client=OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .addInterceptor(AuthInterceptor()).build()
        val type= "application/json".toMediaType()
        val json=Json{ignoreUnknownKeys=true}
        val retrofit by lazy {
            Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client)
                .addConverterFactory(json.asConverterFactory(type))
                .build()
        }
        return retrofit}


    @Provides
    @Singleton
    fun provideApi(retrofit: Retrofit): UnsplashApi {
        return retrofit.create(UnsplashApi::class.java)
    }

}