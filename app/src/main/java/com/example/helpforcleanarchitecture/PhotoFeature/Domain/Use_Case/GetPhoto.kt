package com.example.helpforcleanarchitecture.PhotoFeature.Domain.Use_Case

import com.example.helpforcleanarchitecture.Core.Utils.Resource
import com.example.helpforcleanarchitecture.PhotoFeature.Domain.Model.PhotoModel
import com.example.helpforcleanarchitecture.PhotoFeature.Domain.Repository.PhotoRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetPhoto(
    private val photoRepository: PhotoRepository
) {
    operator fun invoke(): Flow<Resource<List<PhotoModel>>> {
        return photoRepository.getphoto()
    }
}