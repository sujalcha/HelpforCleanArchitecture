package com.example.helpforcleanarchitecture.PhotoFeature.Data.Remote.DTO

import com.example.helpforcleanarchitecture.PhotoFeature.Data.Local.Entity.PhotoEntity
import com.example.helpforcleanarchitecture.PhotoFeature.Domain.Model.PhotoModel

data class PhotoDTO(
    val albumId: Int,
    val id: Int,
    val thumbnailUrl: String,
    val title: String,
    val url: String
){
    fun toPhotoEntity(): PhotoEntity {
        return PhotoEntity(
            id = id,
            albumId = albumId,
            thumbnailUrl = thumbnailUrl,
            title = title,
            url = url
        )
    }
}