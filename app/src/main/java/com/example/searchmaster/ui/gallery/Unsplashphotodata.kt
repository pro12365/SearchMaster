package com.example.searchmaster.ui.gallery
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter

import androidx.paging.PagingData
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.searchmaster.data.unsplashdata
import com.example.searchmaster.databinding.ItemUnsplashBinding

class Unsplashphotodata(diffCallback: DiffUtil.ItemCallback<unsplashdata>) :PagingDataAdapter<unsplashdata,Unsplashphotodata.Photoviewholder>(
    diffCallback
){
    override fun onBindViewHolder(holder: Photoviewholder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Photoviewholder {
        TODO("Not yet implemented")
    }

    class Photoviewholder(private val binding: ItemUnsplashBinding):RecyclerView.ViewHolder(binding.root)
    {

    }
    companion object
    {
        private val photocomperator=object:DiffUtil.ItemCallback<unsplashdata>()
        {
            override fun areItemsTheSame(oldItem: unsplashdata, newItem: unsplashdata): Boolean {
                TODO("Not yet implemented")
            }

            override fun areContentsTheSame(oldItem: unsplashdata, newItem: unsplashdata): Boolean {
                TODO("Not yet implemented")
            }
        }
    }
}
