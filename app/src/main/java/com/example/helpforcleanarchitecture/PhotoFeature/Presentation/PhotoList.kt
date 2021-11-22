package com.example.helpforcleanarchitecture.PhotoFeature.Presentation

import android.util.Log
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.remember
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.compose.runtime.*
import androidx.compose.runtime.getValue

@Composable
fun PhotoList(photoViewModel: PhotoViewModel = hiltViewModel()) {

    val listofphotos by remember { photoViewModel.photolist }


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