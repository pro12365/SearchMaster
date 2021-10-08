package com.example.searchmaster.injectiom

import com.example.searchmaster.api.unsplash_api
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.internal.managers.ApplicationComponentManager
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object Appmodule {
    @Provides
    @Singleton
    fun provideRetrofit():Retrofit=
        Retrofit.Builder().baseUrl(unsplash_api.Base_url).addConverterFactory(GsonConverterFactory.create()).build()
    @Provides
    @Singleton
    fun provideUnsplasapi(retrofit: Retrofit):unsplash_api= retrofit.create(unsplash_api::class.java)
}