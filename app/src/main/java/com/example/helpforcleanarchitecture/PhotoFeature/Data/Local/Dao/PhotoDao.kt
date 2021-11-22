package com.example.helpforcleanarchitecture.PhotoFeature.Data.Local.Dao

import android.util.Log
import androidx.room.*
import com.example.helpforcleanarchitecture.PhotoFeature.Data.Local.Entity.PhotoEntity

@Dao
interface PhotoDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertphoto(listphotoEntity: List<PhotoEntity>)

    @Query("DELETE FROM phototable WHERE id In(:photoid)")
    suspend fun deletephoto(photoid: List<Int>)

    @Query("DELETE FROM phototable")
    suspend fun deleteallphotos()

    @Query("SELECT * FROM phototable")
    suspend fun getallphotos() : List<PhotoEntity>

    @Query("SELECT * FROM phototable WHERE id IN(:photoid)" )
    suspend fun getphotofromid(photoid:IntArray):List<PhotoEntity>


}