package com.example.searchmaster.data

import androidx.paging.Pager
import androidx.paging.PagingConfig
import com.example.searchmaster.api.unsplash_api
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class Unsplashrepository @Inject constructor(private val unsplashApi: unsplash_api) {
    fun getSearchResult(query:String)=
        Pager(
            config = PagingConfig(
                pageSize = 20,
                maxSize = 100,
                enablePlaceholders = false
            ),
            pagingSourceFactory = {UnsplashPagingSource(unsplashApi,query)}
        ).flow

}