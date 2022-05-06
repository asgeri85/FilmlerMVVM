package com.example.filmlermvvmhilt.model


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Yonetmen(
    @SerializedName("yonetmen_ad")
    val yonetmenAd: String?,
    @SerializedName("yonetmen_id")
    val yonetmenİd: String?
):Parcelable