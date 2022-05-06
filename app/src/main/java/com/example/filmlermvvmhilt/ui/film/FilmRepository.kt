package com.example.filmlermvvmhilt.ui.film

import com.example.filmlermvvmhilt.base.BaseRepository
import com.example.filmlermvvmhilt.network.ApiFactory
import javax.inject.Inject

class FilmRepository @Inject constructor(private val apiFactory: ApiFactory) : BaseRepository() {
    suspend fun getFilmByCategory(id: String) =safeApiRequest {
        apiFactory.getFilm(id)
    }


}