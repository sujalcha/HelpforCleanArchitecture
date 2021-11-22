package com.example.helpforcleanarchitecture.PhotoFeature.DI

import android.app.Application
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.helpforcleanarchitecture.PhotoFeature.Data.Local.Database.PhotoDatabase
import com.example.helpforcleanarchitecture.PhotoFeature.Data.Remote.Api.PhotoApi
import com.example.helpforcleanarchitecture.PhotoFeature.Data.Repository.PhotoRepositoryImplementation
import com.example.helpforcleanarchitecture.PhotoFeature.Domain.Model.PhotoModel
import com.example.helpforcleanarchitecture.PhotoFeature.Domain.Repository.PhotoRepository
import com.example.helpforcleanarchitecture.PhotoFeature.Domain.Use_Case.GetPhoto
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object PhotoModule {

    @Provides
    @Singleton
    fun provideGetPhotoUseCase(photoRepository: PhotoRepository): GetPhoto {
        return GetPhoto(photoRepository)
    }

    @Provides
    @Singleton
    fun getphotoapi(): PhotoApi {
        return Retrofit.Builder()
            .baseUrl(PhotoApi.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(PhotoApi::class.java)
    }

    @Provides
    @Singleton
    fun getphotodatabase(application: Application):PhotoDatabase{
        return Room.databaseBuilder(application,PhotoDatabase::class.java,"photo_db")
            .build()

    }

    @Provides
    @Singleton
    fun getremotedatatolocaldata( database: PhotoDatabase,api: PhotoApi): PhotoRepository {

        return PhotoRepositoryImplementation(database.PhotoDao(),api)

    }
}