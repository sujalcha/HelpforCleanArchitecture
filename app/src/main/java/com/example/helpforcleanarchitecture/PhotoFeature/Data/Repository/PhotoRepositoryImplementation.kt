package com.example.helpforcleanarchitecture.PhotoFeature.Data.Repository

import android.util.Log
import androidx.lifecycle.Transformations.map
import com.example.helpforcleanarchitecture.PhotoFeature.Data.Local.Dao.PhotoDao
import com.example.helpforcleanarchitecture.PhotoFeature.Data.Remote.Api.PhotoApi
import com.example.helpforcleanarchitecture.PhotoFeature.Domain.Model.PhotoModel
import com.example.helpforcleanarchitecture.PhotoFeature.Domain.Repository.PhotoRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException


class PhotoRepositoryImplementation (private val photodao: PhotoDao,private val photoapi: PhotoApi) :PhotoRepository{

    override fun getphoto(): Flow<List<PhotoModel>> = flow{
        val photofromdao = photodao.getallphotos().map { it.toPhotoModel() }

        if (photofromdao.isNullOrEmpty()) {
            println("List is null or empty")
        }
        else {
            Log.e("photofromdao",photofromdao.toString())
           // emit(photofromdao)
            Log.e("Emmited from cache","Emmited from cache")
        }


        try {
            val remotePhoto = photoapi.getphotos()

            photodao.deleteallphotos()
            Log.e("All photos deleted","All photos deleted")


            photodao.insertphoto( remotePhoto.map{it.toPhotoEntity()} )
            Log.e("Emmited from network",remotePhoto.map{it.toPhotoEntity()}.toString())

        } catch(e: HttpException) {

            Log.e("http excpetion, error", "http excpetion, error")
        } catch(e: IOException) {
            Log.e("http excpetion, error", "http excpetion, error")
        }

        val newphoto = photodao.getallphotos().map { it.toPhotoModel() }

        Log.e("newphoto",newphoto.toString())




        if (newphoto.isNullOrEmpty()) {
            println("List is null or empty")
        }
        else {
            emit(newphoto)
        }
    }
}