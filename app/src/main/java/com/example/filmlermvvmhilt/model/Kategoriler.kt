package com.example.filmlermvvmhilt.model


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Kategoriler(
    @SerializedName("kategori_ad")
    val kategoriAd: String?,
    @SerializedName("kategori_id")
    val kategoriİd: String?
):Parcelable