package com.example.filmlermvvmhilt.model


import com.google.gson.annotations.SerializedName

data class FilmResponseModel(
    @SerializedName("filmler")
    val filmler: List<Filmler>?,
    @SerializedName("success")
    val success: Int?
)