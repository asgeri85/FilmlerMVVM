package com.example.filmlermvvmhilt.model


import com.google.gson.annotations.SerializedName

data class ErrorResponseModel(
    @SerializedName("message")
    val message: String?,
    @SerializedName("success")
    val success: Int?
)