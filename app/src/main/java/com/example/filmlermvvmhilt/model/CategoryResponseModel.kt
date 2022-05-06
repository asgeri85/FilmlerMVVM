package com.example.filmlermvvmhilt.model


import com.google.gson.annotations.SerializedName

data class CategoryResponseModel(
    @SerializedName("kategoriler")
    val kategoriler: List<Kategoriler>?,
    @SerializedName("success")
    val success: Int?
)