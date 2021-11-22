package com.example.helpforcleanarchitecture.PhotoFeature.Data.Local.Entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.helpforcleanarchitecture.PhotoFeature.Domain.Model.PhotoModel

@Entity(tableName = "phototable")
data class PhotoEntity(

    @PrimaryKey(autoGenerate = false)
    val id: Int,
    val albumId: Int,
    val thumbnailUrl: String,
    val title: String,
    val url: String

)
{
    fun toPhotoModel(): PhotoModel {
        return PhotoModel(
            id = id,
            albumId = albumId,
            thumbnailUrl = thumbnailUrl,
            title = title,
            url = url
        )
    }
}
