package com.example.helpforcleanarchitecture.PhotoFeature.Domain.Model

data class PhotoModel(

    val id: Int,
    val albumId: Int,
    val thumbnailUrl: String,
    val title: String,
    val url: String
)
