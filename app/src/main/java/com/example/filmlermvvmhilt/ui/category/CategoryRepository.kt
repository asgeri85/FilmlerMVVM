package com.example.filmlermvvmhilt.ui.category

import com.example.filmlermvvmhilt.base.BaseRepository
import com.example.filmlermvvmhilt.network.ApiFactory
import javax.inject.Inject

class CategoryRepository @Inject constructor(private val apiFactory: ApiFactory):BaseRepository() {

    suspend fun getCategoryData()=safeApiRequest {
        apiFactory.getAllCategory()
    }
}