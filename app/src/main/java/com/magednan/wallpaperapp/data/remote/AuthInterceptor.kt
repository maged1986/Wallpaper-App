package com.magednan.wallpaperapp.data.remote

import com.magednan.wallpaperapp.utils.Constants.CLIENT_Id
import okhttp3.Interceptor
import okhttp3.Response

class AuthInterceptor :Interceptor{
    override fun intercept(chain: Interceptor.Chain): Response {
        val baseRequest=chain.request()
        val baseUrl=baseRequest.url

        val newUrl=baseUrl.newBuilder().addQueryParameter(CLIENT_Id,"uKuohHCkTpIJk6l_trwKRMKZeGi1B99D4HE1EGceTMU").build()
        val newRequest=baseRequest.newBuilder().url(newUrl).build()
        return chain.proceed(newRequest)

    }
}