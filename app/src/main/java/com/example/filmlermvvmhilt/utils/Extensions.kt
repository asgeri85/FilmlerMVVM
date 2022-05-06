package com.example.filmlermvvmhilt.utils

import android.widget.ImageView
import coil.load
import com.example.filmlermvvmhilt.R

fun ImageView.loadImageUrl(url:String?){
    this.load(url){
        crossfade(true)
        crossfade(500)
        placeholder(R.drawable.ic_android_black_24dp)
    }
}
