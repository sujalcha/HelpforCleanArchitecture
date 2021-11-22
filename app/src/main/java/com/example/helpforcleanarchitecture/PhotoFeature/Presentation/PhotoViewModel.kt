package com.example.helpforcleanarchitecture.PhotoFeature.Presentation

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.helpforcleanarchitecture.PhotoFeature.Domain.Model.PhotoModel
import com.example.helpforcleanarchitecture.PhotoFeature.Domain.Use_Case.GetPhoto
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PhotoViewModel @Inject constructor(
    val getPhoto: GetPhoto
) :ViewModel() {

    val photolist = mutableStateOf<List<PhotoModel>>(listOf())

    init {
        getphotofromviewmodel()
    }


    fun getphotofromviewmodel(){
        viewModelScope.launch {

            getPhoto().onEach {result ->
                if (result!= null)
                {
                    for(r in result)
                    {
                        photolist.value +=PhotoModel(r.id,r.albumId,r.title,r.thumbnailUrl,r.url)
                    }
                }

                else{
                    Log.e("result is null","")
                }
               }.toList()


            Log.e("Photolist",photolist.value.toString())

        }

    }
}