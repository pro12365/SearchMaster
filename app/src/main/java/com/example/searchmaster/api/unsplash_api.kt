package com.example.searchmaster.api

import com.example.searchmaster.BuildConfig
import retrofit2.http.*

interface unsplash_api {
    companion object
    {
        const val Base_url="https://unsplash.com/"
        const val CLIENT_ID= BuildConfig.UNSPLASH_ACESS_KEY
    }
    @Headers("Accept Version:v1,","")
    @GET("search/photos")
    suspend fun searchphotos(
@Query("query")query: String,
@Query("page")page:Int,
@Query("perpage")perpage:Int,
    ):unsplash_response
}