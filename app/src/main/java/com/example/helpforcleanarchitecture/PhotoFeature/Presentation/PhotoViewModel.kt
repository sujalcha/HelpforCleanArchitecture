package com.example.helpforcleanarchitecture.PhotoFeature.Presentation

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.helpforcleanarchitecture.Core.Utils.Resource
import com.example.helpforcleanarchitecture.PhotoFeature.Domain.Model.PhotoModel
import com.example.helpforcleanarchitecture.PhotoFeature.Domain.Use_Case.GetPhoto
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import java.util.stream.Collectors.toList
import javax.inject.Inject

@HiltViewModel
class PhotoViewModel @Inject constructor(
    val getPhoto: GetPhoto
) : ViewModel() {

    var isLoading = mutableStateOf(false)
    var loadError = mutableStateOf("")
    val photolist = mutableStateOf<List<PhotoModel>>(listOf())

    init {
        getphotofromviewmodel()
    }

    fun getphotofromviewmodel() {
        viewModelScope.launch {
            isLoading.value = true

            getPhoto().onEach { result ->
                when (result) {
                    is Resource.Success -> {
                        result.data!!.mapIndexed { index, entry ->
                            photolist.value += PhotoModel(
                                entry.id,
                                entry.albumId,
                                entry.title,
                                entry.thumbnailUrl,
                                entry.url
                            )
                        }
                        isLoading.value = false
                    }
                    is Resource.Error -> {
                        photolist.value= emptyList()
                        loadError.value = result.message.toString()
                        isLoading.value = false
                    }
                    is Resource.Loading -> {
                        isLoading.value = true
                    }
                }
            }.launchIn(this)

            Log.e("Photolist", photolist.value.toString())

        }

    }

    sealed class UIEvent {
        data class ShowSnackbar(val message: String): UIEvent()
    }
}