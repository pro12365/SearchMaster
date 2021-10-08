package com.example.searchmaster.ui.gallery

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.example.searchmaster.api.unsplash_api
import com.example.searchmaster.data.Unsplashrepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.switchMap
import retrofit2.http.Query
import javax.inject.Inject
@HiltViewModel
class GalleryViewModel @Inject constructor(private val repo:Unsplashrepository):ViewModel() {
    private val currentquery= MutableStateFlow(Default_Query)
    val photos=   currentquery.flatMapLatest{
            queryString->repo.getSearchResult(queryString).cachedIn(viewModelScope)
    }
    fun searchphotos(query: String)
    {
        currentquery.value=query
    }
    companion object
    {
        private const val Default_Query= "cats"
    }
}