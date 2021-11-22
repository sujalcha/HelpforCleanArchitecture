package com.example.helpforcleanarchitecture.PhotoFeature.Domain.Repository

import com.example.helpforcleanarchitecture.PhotoFeature.Domain.Model.PhotoModel
import kotlinx.coroutines.flow.Flow

interface PhotoRepository {

    fun getphoto(): Flow<List<PhotoModel>>
}