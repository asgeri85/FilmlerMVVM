package com.example.filmlermvvmhilt.adapters

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.example.filmlermvvmhilt.utils.Constants.BASE_URL
import com.example.filmlermvvmhilt.utils.loadImageUrl

object BindingAdapters {

    @BindingAdapter("load_image")
    @JvmStatic
    fun loadImage(imageView: ImageView,filmName:String){
        val url="${BASE_URL}resimler/$filmName"
        imageView.loadImageUrl(url)
    }
}