package com.example.searchmaster.data

import androidx.paging.LoadState
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.searchmaster.api.unsplash_api
import retrofit2.HttpException
import java.io.IOException

private const val Unsplash_Api_Starting_Page=1
class UnsplashPagingSource(private val unsplashapi:unsplash_api,private val searchquery:String):PagingSource<Int,unsplashdata>(){
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, unsplashdata> {
        val positon= params.key ?: Unsplash_Api_Starting_Page
        return try {
            val response= unsplashapi.searchphotos(searchquery,positon,params.loadSize)
            val  photos= response.results
            LoadResult.Page(data = photos,prevKey = if (positon==Unsplash_Api_Starting_Page)null else positon-1,
                nextKey = if(photos.isEmpty())null else positon+1)
        }
        catch (Exception:IOException)
        {
            LoadResult.Error(Exception)
        }
        catch (Exception:HttpException)
        {
            LoadResult.Error(Exception)
        }

    }

    override fun getRefreshKey(state: PagingState<Int, unsplashdata>): Int? {
        TODO("Not yet implemented")
    }
}



