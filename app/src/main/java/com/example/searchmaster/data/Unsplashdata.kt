package com.example.searchmaster.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
    data class unsplashdata(val id:String, val description: String?, val url: urlholder, val user: userholder,):
        Parcelable
    {
      @Parcelize
        data class urlholder(val raw:String,val regular:String,val small:String,val thumb:String,):
            Parcelable
        @Parcelize
        data class userholder(val name:String,val username:String): Parcelable
        {
            val attributionUrl get() = "https//unsplash.com/$username?utm_source=ImasgeSearch&utm_medium=referral"
        }
    }
