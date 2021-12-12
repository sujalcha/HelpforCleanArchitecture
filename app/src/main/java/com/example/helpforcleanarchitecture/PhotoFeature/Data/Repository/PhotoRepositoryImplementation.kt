package com.example.helpforcleanarchitecture.PhotoFeature.Data.Repository

import android.util.Log
import androidx.lifecycle.Transformations.map
import com.example.helpforcleanarchitecture.Core.Utils.Resource
import com.example.helpforcleanarchitecture.PhotoFeature.Data.Local.Dao.PhotoDao
import com.example.helpforcleanarchitecture.PhotoFeature.Data.Remote.Api.PhotoApi
import com.example.helpforcleanarchitecture.PhotoFeature.Domain.Model.PhotoModel
import com.example.helpforcleanarchitecture.PhotoFeature.Domain.Repository.PhotoRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException


class PhotoRepositoryImplementation (private val photodao: PhotoDao,private val photoapi: PhotoApi) :PhotoRepository{

    override fun getphoto(): Flow<Resource<List<PhotoModel>>> = flow{

        emit(Resource.Loading())

        val photofromdao = photodao.getallphotos().map { it.toPhotoModel() }
        emit(Resource.Loading(data = photofromdao))


        try {
            val remotePhoto = photoapi.getphotos()

            photodao.deleteallphotos()
            Log.d("All photos deleted","All photos deleted")

            photodao.insertphoto( remotePhoto.map{it.toPhotoEntity()} )
            Log.d("Emmited from network",remotePhoto.map{it.toPhotoEntity()}.toString())

        } catch(e: HttpException) {
            Log.d("http excpetion error", e.message.toString())
            emit(Resource.Error(
                message = e.message.toString(),
                data = photofromdao
            ))
        } catch(e: IOException) {
            Log.d("IO excpetion, error", e.message.toString())
            emit(Resource.Error(
                message = e.message.toString(),
                data = photofromdao
            ))
        }

        val newphoto = photodao.getallphotos().map { it.toPhotoModel() }
        Log.d("newphoto",newphoto.toString())

        if (newphoto.isNullOrEmpty()) {
            println("List is null or empty")
        }
        else {
            emit(Resource.Success(newphoto))
        }
    }
}