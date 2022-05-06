package com.example.filmlermvvmhilt.model


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Filmler(
    @SerializedName("film_ad")
    val filmAd: String?,
    @SerializedName("film_resim")
    val filmResim: String?,
    @SerializedName("film_yil")
    val filmYil: String?,
    @SerializedName("film_id")
    val filmİd: String?,
    @SerializedName("kategori")
    val kategori: Kategoriler?,
    @SerializedName("yonetmen")
    val yonetmen: Yonetmen?
):Parcelable