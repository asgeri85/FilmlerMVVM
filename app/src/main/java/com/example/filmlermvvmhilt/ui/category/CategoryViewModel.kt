package com.example.filmlermvvmhilt.ui.category

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.filmlermvvmhilt.model.CategoryResponseModel
import com.example.filmlermvvmhilt.utils.NetworkResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CategoryViewModel @Inject constructor(private val categoryRepository: CategoryRepository) :
    ViewModel() {

    private val _categoryData = MutableLiveData<CategoryResponseModel?>()
    val categoryData: LiveData<CategoryResponseModel?>
        get() = _categoryData

    private val _loading = MutableLiveData<Boolean>()
    val loading: LiveData<Boolean>
        get() = _loading

    private val _error = MutableLiveData<String?>()
    val error: LiveData<String?>
        get() = _error

    init {
        getAllCategory()
    }

    private fun getAllCategory() {
        viewModelScope.launch {
            _loading.value = true
            val request = categoryRepository.getCategoryData()
            when (request) {
                is NetworkResult.Success -> {
                    _categoryData.value = request.data
                    _loading.value = false
                }

                is NetworkResult.Error -> {
                    _error.value = request.message
                    _loading.value = false
                }
            }
        }
    }
}