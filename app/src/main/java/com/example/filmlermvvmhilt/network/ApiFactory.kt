package com.example.filmlermvvmhilt.network

import com.example.filmlermvvmhilt.model.CategoryResponseModel
import com.example.filmlermvvmhilt.model.FilmResponseModel
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiFactory {

    @GET("tum_kategoriler.php")
    suspend fun getAllCategory():CategoryResponseModel

    @POST("filmler_by_kategori_id.php")
    @FormUrlEncoded
    suspend fun getFilm(@Field("kategori_id") id:String):FilmResponseModel
}