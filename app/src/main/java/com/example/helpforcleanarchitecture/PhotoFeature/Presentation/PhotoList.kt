package com.example.helpforcleanarchitecture.PhotoFeature.Presentation

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.remember
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.compose.runtime.*
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun PhotoList(photoViewModel: PhotoViewModel = hiltViewModel()) {

    val listofphotos by remember { photoViewModel.photolist }
    val loadError by remember { photoViewModel.loadError }
    val isLoading by remember { photoViewModel.isLoading }

    Box(modifier = Modifier.fillMaxSize() ){

        if(isLoading)
        {
            CircularProgressIndicator(modifier = Modifier.fillMaxWidth())
        }

        LazyColumn(){
            Log.e("listofphotos.size", listofphotos.size.toString())
            item(listofphotos.size){
                for (photo in listofphotos)
                {
                    PhotoDetail(photoModel = photo)
                }

            }
        }
    }




    
}