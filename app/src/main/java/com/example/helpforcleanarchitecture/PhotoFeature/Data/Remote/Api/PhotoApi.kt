package com.example.helpforcleanarchitecture.PhotoFeature.Data.Remote.Api

import com.example.helpforcleanarchitecture.PhotoFeature.Data.Remote.DTO.PhotoDTO
import retrofit2.http.GET


interface PhotoApi {
    @GET("/photos")
    suspend fun getphotos() : List<PhotoDTO>

    companion object{
        const val BASE_URL = "https://jsonplaceholder.typicode.com"
    }
}