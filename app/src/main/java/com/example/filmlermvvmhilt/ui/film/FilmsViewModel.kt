package com.example.filmlermvvmhilt.ui.film

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.filmlermvvmhilt.model.FilmResponseModel
import com.example.filmlermvvmhilt.utils.NetworkResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FilmsViewModel @Inject constructor(private val filmRepository: FilmRepository) : ViewModel() {

    private val _filmData = MutableLiveData<FilmResponseModel?>()
    val filmData: LiveData<FilmResponseModel?>
        get() = _filmData

    private val _error = MutableLiveData<String?>()
    val error: LiveData<String?>
        get() = _error

    private val _loading = MutableLiveData<Boolean>()
    val loading: LiveData<Boolean>
        get() = _loading


    fun getFilmDataById(id: String) {
        viewModelScope.launch {
            _loading.value = true
            val request = filmRepository.getFilmByCategory(id)
            when (request) {
                is NetworkResult.Success -> {
                    _filmData.value = request.data
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